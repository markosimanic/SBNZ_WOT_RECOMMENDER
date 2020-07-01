package com.example.WoTRecommender.service.impl;

import java.util.List;

import com.example.WoTRecommender.model.User;
import com.example.WoTRecommender.repository.UserRepository;
import com.example.WoTRecommender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        return u;
    }

    public User findById(Long id) throws AccessDeniedException {
        User u = userRepository.findById(id).orElseGet(null);
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

}
