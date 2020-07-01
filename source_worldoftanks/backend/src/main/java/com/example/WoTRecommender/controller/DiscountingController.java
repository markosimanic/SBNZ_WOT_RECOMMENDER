package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.UserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/discounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiscountingController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private KieSession session;

    @GetMapping(path = "/getAllUsers")
    public List<User> users(){
        return userRepository.findAll();
    }

    @PostMapping(path ="/setDiscount")
    public User setUserDiscount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User u = userRepository.findByUsername(currentPrincipalName);
        session.insert(u);
        session.fireAllRules();
        return u;
    }
}
