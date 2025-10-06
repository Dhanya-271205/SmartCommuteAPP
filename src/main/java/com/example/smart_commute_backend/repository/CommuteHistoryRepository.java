package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.entity.CommuteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommuteHistoryRepository extends JpaRepository<CommuteHistory, Long> {
    List<CommuteHistory> findByUserId(Long userId);
}
