package com.example.smartcommutebackend.model;

import jakarta.persistence.*;

@Entity
public class MetroLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String stationSequence; // comma-separated station IDs

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStationSequence() {
        return stationSequence;
    }

    public void setStationSequence(String stationSequence) {
        this.stationSequence = stationSequence;
    }
}
