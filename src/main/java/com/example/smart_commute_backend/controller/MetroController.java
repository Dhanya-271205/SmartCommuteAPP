package com.example.smartcommutebackend.controller;

import com.example.smartcommutebackend.model.MetroLine;
import com.example.smartcommutebackend.model.MetroStation;
import com.example.smartcommutebackend.repository.MetroLineRepository;
import com.example.smartcommutebackend.repository.MetroStationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metro")
public class MetroController {

    private final MetroStationRepository metroStationRepository;
    private final MetroLineRepository metroLineRepository;

    public MetroController(MetroStationRepository metroStationRepository, MetroLineRepository metroLineRepository) {
        this.metroStationRepository = metroStationRepository;
        this.metroLineRepository = metroLineRepository;
    }

    // Get all metro stations
    @GetMapping("/stations")
    public List<MetroStation> getAllStations() {
        return metroStationRepository.findAll();
    }

    // Get all metro lines
    @GetMapping("/lines")
    public List<MetroLine> getAllLines() {
        return metroLineRepository.findAll();
    }

    // Get stations for a specific line
    @GetMapping("/lines/{lineName}/stations")
    public List<MetroStation> getStationsByLine(@PathVariable String lineName) {
        MetroLine line = metroLineRepository.findAll().stream()
                .filter(l -> l.getName().equalsIgnoreCase(lineName))
                .findFirst()
                .orElse(null);

        if (line == null)
            return List.of();

        String[] stationIds = line.getStationSequence().split(",");
        return metroStationRepository.findAll().stream()
                .filter(s -> {
                    for (String id : stationIds)
                        if (s.getId() == Long.parseLong(id))
                            return true;
                    return false;
                })
                .toList();
    }
}
