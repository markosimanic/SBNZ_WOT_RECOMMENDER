package com.example.WoTRecommender.repository;

import com.example.WoTRecommender.model.Tank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TankRepository extends JpaRepository<Tank,Long> {

    Optional<Tank> findById(Long id);
}