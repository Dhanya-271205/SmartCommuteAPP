package com.example.smartcommutebackend.controller;

import com.example.smartcommutebackend.entity.CommuteHistory;
import com.example.smartcommutebackend.repository.CommuteHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commutes")
public class CommuteHistoryController {

    private final CommuteHistoryRepository commuteHistoryRepository;

    public CommuteHistoryController(CommuteHistoryRepository commuteHistoryRepository) {
        this.commuteHistoryRepository = commuteHistoryRepository;
    }

    // Get all commutes
    @GetMapping
    public List<CommuteHistory> getAllCommutes() {
        return commuteHistoryRepository.findAll();
    }

    // Get commutes by userId
    @GetMapping("/user/{userId}")
    public List<CommuteHistory> getCommutesByUser(@PathVariable Long userId) {
        return commuteHistoryRepository.findByUserId(userId);
    }

    // Create a new commute
    @PostMapping
    public CommuteHistory createCommute(@RequestBody CommuteHistory commute) {
        return commuteHistoryRepository.save(commute);
    }
}
