package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.Tank;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.model.UserTank;
import com.example.WoTRecommender.model.UserTankKey;
import com.example.WoTRecommender.repository.UserRepository;
//import com.example.WoTRecommender.repository.UserTankKeyRepository;
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
//
//    @Autowired
//    UserTankKeyRepository userTankKeyRepository;

    @Autowired
    private KieSession session;

    @GetMapping(path = "/getAllUsers")
    public List<User> users(){
        return userRepository.findAll();
    }

    @PostMapping(path ="/buyTank")
    public User buyTank(@RequestBody Tank tank){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User u = userRepository.findByUsername(currentPrincipalName);

        Integer userBalance = u.getBalance();
        Integer tankPrice = tank.getPrice();
        List<UserTank> userTanks = u.getTanks();

        UserTank boughtTank = new UserTank();
        UserTankKey utk = new UserTankKey();
        utk.setTankID(tank.getId());
        utk.setUserID(u.getId());
       // userTankKeyRepository.save(utk);

        boughtTank.setId(utk);
        boughtTank.setUser(u);
        boughtTank.setTank(tank);

        boolean alreadyOwned = false;
        for (UserTank ut: userTanks) {
                if (ut.getTank().getName().equals(tank.getName())) {
                    alreadyOwned = true;
                break;
            }
        }
        if(!alreadyOwned){
            if (tankPrice<=userBalance)
            {
                u.setBalance(userBalance-tankPrice);
                userTanks.add(boughtTank);
                u.setTanks(userTanks);
                System.out.println(userTanks);
                userRepository.save(u);
            }
        }
        return u;
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
