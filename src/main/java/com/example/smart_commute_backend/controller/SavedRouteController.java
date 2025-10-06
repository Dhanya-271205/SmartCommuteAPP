package com.example.smartcommutebackend.controller;

import com.example.smartcommutebackend.entity.SavedRoute;
import com.example.smartcommutebackend.repository.SavedRouteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saved-routes")
public class SavedRouteController {

    private final SavedRouteRepository savedRouteRepository;

    public SavedRouteController(SavedRouteRepository savedRouteRepository) {
        this.savedRouteRepository = savedRouteRepository;
    }

    // Get all saved routes
    @GetMapping
    public List<SavedRoute> getAllSavedRoutes() {
        return savedRouteRepository.findAll();
    }

    // Get saved routes by userId
    @GetMapping("/user/{userId}")
    public List<SavedRoute> getSavedRoutesByUser(@PathVariable Long userId) {
        return savedRouteRepository.findByUserId(userId);
    }

    // Create a new saved route
    @PostMapping
    public SavedRoute createSavedRoute(@RequestBody SavedRoute route) {
        return savedRouteRepository.save(route);
    }
}
