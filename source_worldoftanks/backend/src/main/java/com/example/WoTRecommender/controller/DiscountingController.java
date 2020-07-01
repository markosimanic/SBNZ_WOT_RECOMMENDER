package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.UserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(path ="/setDiscount/{username}")
    public User setUserDiscount(@PathVariable String username){

        User u = userRepository.findByUsername(username);
        session.insert(u);
        session.fireAllRules();
        return u;
    }
}
