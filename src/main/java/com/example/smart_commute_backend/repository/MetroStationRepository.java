package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.model.MetroStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetroStationRepository extends JpaRepository<MetroStation, Long> {
}
