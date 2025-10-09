package com.example.smartcommutebackend.controller;

import com.example.smartcommutebackend.model.BusStop;
import com.example.smartcommutebackend.model.BusRoute;
import com.example.smartcommutebackend.repository.BusStopRepository;
import com.example.smartcommutebackend.repository.BusRouteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173") // frontend URL
@RestController
@RequestMapping("/api/bus")
public class BusController {

    private final BusStopRepository busStopRepository;
    private final BusRouteRepository busRouteRepository;

    public BusController(BusStopRepository busStopRepository, BusRouteRepository busRouteRepository) {
        this.busStopRepository = busStopRepository;
        this.busRouteRepository = busRouteRepository;
    }

    // Get all bus stops
    @GetMapping("/stops")
    public List<BusStop> getAllStops() {
        return busStopRepository.findAll();
    }

    // Get all bus routes
    @GetMapping("/routes")
    public List<BusRoute> getAllRoutes() {
        return busRouteRepository.findAll();
    }

    // Get bus stops for a specific route
    @GetMapping("/routes/{routeNumber}/stops")
    public List<BusStop> getStopsByRoute(@PathVariable String routeNumber) {
        BusRoute route = busRouteRepository.findAll().stream()
                .filter(r -> r.getRouteNumber().equalsIgnoreCase(routeNumber))
                .findFirst()
                .orElse(null);

        if (route == null)
            return List.of();

        String[] stopIds = route.getStopSequence().split(",");
        return busStopRepository.findAll().stream()
                .filter(s -> {
                    for (String id : stopIds)
                        if (s.getId() == Long.parseLong(id))
                            return true;
                    return false;
                })
                .toList();
    }
}
