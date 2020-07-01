package com.example.WoTRecommender.repository;

import com.example.WoTRecommender.model.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<PlayerStatistics,Long> {
}
