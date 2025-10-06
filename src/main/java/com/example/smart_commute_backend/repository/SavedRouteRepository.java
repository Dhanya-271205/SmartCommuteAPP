package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.entity.SavedRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SavedRouteRepository extends JpaRepository<SavedRoute, Long> {
    List<SavedRoute> findByUserId(Long userId);
}
