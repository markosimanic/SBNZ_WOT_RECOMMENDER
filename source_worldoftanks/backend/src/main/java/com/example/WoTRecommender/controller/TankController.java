package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.Characteristics;
import com.example.WoTRecommender.model.PlayerStatistics;
import com.example.WoTRecommender.model.Tank;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.CharacteristicsRepository;
import com.example.WoTRecommender.repository.StatisticsRepository;
import com.example.WoTRecommender.repository.TankRepository;
import com.example.WoTRecommender.repository.UserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/tanks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TankController {

    @Autowired
    private KieSession session;

    @Autowired
    private TankRepository tankRepository;

    @Autowired
    CharacteristicsRepository charRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    @PostMapping(path ="/changeTankType")
    public Tank changeType(@RequestBody Tank tank){
        session.insert(tank);
        session.fireAllRules();
        return tank;
    }

    @GetMapping(path ="/getAllTanks")
    public List<Tank> getAllTanks(){ return tankRepository.findAll(); }

    @GetMapping(path="/getAllChars")
    public List<Characteristics> getAllCharacteristics(){
        return charRepo.findAll();}


}
