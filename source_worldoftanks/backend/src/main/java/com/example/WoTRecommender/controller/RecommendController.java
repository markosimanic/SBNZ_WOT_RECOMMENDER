package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.Characteristics;
import com.example.WoTRecommender.model.Tank;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.TankRepository;
import com.example.WoTRecommender.repository.UserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recommend")
public class RecommendController {

    @Autowired
    private KieSession session;

    @Autowired
    private TankRepository tankRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/playstyle")
    public User recommendTankPlaystyle(@RequestBody List<Characteristics> chars){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user  = userRepository.findByUsername(currentPrincipalName);
        user.setUser_characteristics(chars);
        userRepository.save(user);
        session.insert(user);

        List<Tank> tanks = tankRepository.findAll();
        for (Tank tank: tanks) {
            session.insert(tank);
        }
        session.fireAllRules();

        return user;

    }

}
