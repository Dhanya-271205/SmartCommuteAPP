package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}
