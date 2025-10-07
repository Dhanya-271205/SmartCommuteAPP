package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.model.MetroLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetroLineRepository extends JpaRepository<MetroLine, Long> {
}
