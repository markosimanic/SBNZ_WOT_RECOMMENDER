package com.example.WoTRecommender.repository;

import com.example.WoTRecommender.model.UserTank;
import com.example.WoTRecommender.model.UserTankKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTankRepository extends JpaRepository<UserTank, UserTankKey> {
}
