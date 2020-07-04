package com.example.WoTRecommender.controller;


import com.example.WoTRecommender.model.PlayerStatistics;
import com.example.WoTRecommender.model.Tank;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.StatisticsRepository;
import com.example.WoTRecommender.repository.TankRepository;
import com.example.WoTRecommender.repository.UserRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticsController {
    //based on player statistics on current tank

    @Autowired
    StatisticsRepository statisticsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TankRepository tankRepository;

    @Autowired
    private KieContainer kieContainer;

    @GetMapping(path="/current")
    public List<PlayerStatistics> getStatsOfCurrentUser(){

        KieSession kieSession = kieContainer.newKieSession();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User currentUser = userRepository.findByUsername(currentPrincipalName);
        Long id = currentUser.getId();
        kieSession.insert(currentUser);

        List<Tank> allTanksInSystem = tankRepository.findAll();
        for (Tank t:allTanksInSystem) {
            kieSession.insert(t);
        }

        List<PlayerStatistics> pstats = statisticsRepository.findAll();
        List<PlayerStatistics> statistics_of_current_user = new ArrayList<>();
        for (PlayerStatistics ps : pstats) {
            if(id.equals(ps.getUserTank().getId().getUserID())){
                statistics_of_current_user.add(ps);
                kieSession.insert(ps);
            }
        }

        kieSession.getAgenda().getAgendaGroup("statistics").setFocus();
        kieSession.fireAllRules();

        kieSession.dispose();

        userRepository.save(currentUser);

        return statistics_of_current_user;
    }
}
