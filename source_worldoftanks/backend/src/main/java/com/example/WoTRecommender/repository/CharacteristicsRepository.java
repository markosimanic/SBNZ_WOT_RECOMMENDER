package com.example.WoTRecommender.repository;

import com.example.WoTRecommender.model.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristics, Long> {
}
