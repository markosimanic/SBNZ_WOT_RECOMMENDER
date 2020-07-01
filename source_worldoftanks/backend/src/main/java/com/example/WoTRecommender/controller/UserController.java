package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.Tank;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.model.UserTank;
import com.example.WoTRecommender.repository.TankRepository;
import com.example.WoTRecommender.repository.UserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TankRepository tankRepository;

    @Autowired
    private KieSession session;


    @GetMapping(path ="/getUser")
    public User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user  = userRepository.findByUsername(currentPrincipalName);
        return user;
    }

    @GetMapping(path="/getAllUserTanks")
    public List<Tank> userTanks(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user  = userRepository.findByUsername(currentPrincipalName);
        List<Tank> userTanks = new ArrayList<>();
        for (UserTank ut: user.getTanks()) {
            userTanks.add(ut.getTank());
        }
        return userTanks;
    }

    //api for rule "Give 20% discount to user if he bought more than 2 PREMIUM tanks
    @GetMapping(path="/giveDiscount")
    public User giveDiscountForPremiums(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user  = userRepository.findByUsername(currentPrincipalName);
        session.insert(user);
        for (UserTank ut: user.getTanks()) {
            session.insert(ut.getTank());
        }
        session.fireAllRules();
        return user;
    }




}
