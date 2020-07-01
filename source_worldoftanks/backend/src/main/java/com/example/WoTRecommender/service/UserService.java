package com.example.WoTRecommender.service;

import com.example.WoTRecommender.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
}
