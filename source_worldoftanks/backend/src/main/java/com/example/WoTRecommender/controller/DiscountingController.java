package com.example.WoTRecommender.controller;

import com.example.WoTRecommender.model.Tank;
import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.model.UserTank;
import com.example.WoTRecommender.model.UserTankKey;
import com.example.WoTRecommender.repository.TankRepository;
import com.example.WoTRecommender.repository.UserRepository;
//import com.example.WoTRecommender.repository.UserTankKeyRepository;
import com.example.WoTRecommender.repository.UserTankRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/discounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiscountingController {

    @Autowired
    UserRepository userRepository;
//
//    @Autowired
//    UserTankKeyRepository userTankKeyRepository;

    @Autowired
    TankRepository tankRepository;

    @Autowired
    UserTankRepository userTankRepository;

    @Autowired
    private KieContainer kieContainer;

    @GetMapping(path = "/getAllUsers")
    public List<User> users(){
        return userRepository.findAll();
    }

    @PostMapping(path ="/buyTank")
    public ResponseEntity<User> buyTank(@RequestParam Long tankId){

        KieSession kieSession = kieContainer.newKieSession();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User u = userRepository.findByUsername(currentPrincipalName);

        Optional<Tank> chosenTank = tankRepository.findById(tankId);

        Tank tank = chosenTank.get();

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
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        if(!alreadyOwned){
            if (tankPrice<=userBalance)
            {
                userTankRepository.save(boughtTank);
                u.setBalance(userBalance-tankPrice);
                u.setPaidmoney(u.getPaidmoney() + tankPrice);
                userTanks.add(boughtTank);
                u.setTanks(userTanks);
                userRepository.save(u);
            }else{
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        for (UserTank usertank: userTanks) {
            kieSession.insert(usertank);
        }

        kieSession.insert(u);
        kieSession.getAgenda().getAgendaGroup("discounts").setFocus();
        kieSession.fireAllRules();

        kieSession.dispose();

        userRepository.save(u);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path ="/setDiscount")
        public User setUserDiscount(){

        KieSession kieSession = kieContainer.newKieSession();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User u = userRepository.findByUsername(currentPrincipalName);
        kieSession.insert(u);
        kieSession.fireAllRules();
        return u;
    }
}
