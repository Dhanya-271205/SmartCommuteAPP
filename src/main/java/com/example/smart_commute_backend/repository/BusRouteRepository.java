package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.model.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
}
