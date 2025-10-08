package com.example.smartcommutebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/all-tables")
    public String testAllTables() {
        StringBuilder sb = new StringBuilder();

        try {
            Integer busStops = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM bus_stops", Integer.class);
            sb.append("Bus Stops count: ").append(busStops).append("\n");

            Integer busRoutes = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM bus_routes", Integer.class);
            sb.append("Bus Routes count: ").append(busRoutes).append("\n");

            Integer metroStations = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM metro_stations", Integer.class);
            sb.append("Metro Stations count: ").append(metroStations).append("\n");

            Integer metroLines = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM metro_lines", Integer.class);
            sb.append("Metro Lines count: ").append(metroLines).append("\n");

        } catch (Exception e) {
            sb.append("Database connection failed: ").append(e.getMessage());
        }

        return sb.toString();
    }
}
