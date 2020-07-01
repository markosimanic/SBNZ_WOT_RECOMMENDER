package com.example.WoTRecommender.controller;


import com.example.WoTRecommender.model.PlayerStatistics;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.StatisticsRepository;
import com.example.WoTRecommender.repository.UserRepository;
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

    @GetMapping(path="/current")
    public List<PlayerStatistics> getStatsOfCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User currentUser = userRepository.findByUsername(currentPrincipalName);
        Long id = currentUser.getId();

        List<PlayerStatistics> pstats = statisticsRepository.findAll();
        List<PlayerStatistics> statistics_of_current_user = new ArrayList<>();
        for (PlayerStatistics ps : pstats) {
            if(id.equals(ps.getUserTank().getId().getUserID())){
                statistics_of_current_user.add(ps);
            }
        }
        return statistics_of_current_user;
    }
}
