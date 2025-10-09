package com.example.smartcommutebackend.dto;

import java.util.List;

public class RouteResponse {
    private List<RouteOption> metro;
    private List<RouteOption> bus;
    private List<RouteOption> train;

    // Constructors
    public RouteResponse() {
    }

    public RouteResponse(List<RouteOption> metro, List<RouteOption> bus, List<RouteOption> train) {
        this.metro = metro;
        this.bus = bus;
        this.train = train;
    }

    // Getters & Setters
    public List<RouteOption> getMetro() {
        return metro;
    }

    public void setMetro(List<RouteOption> metro) {
        this.metro = metro;
    }

    public List<RouteOption> getBus() {
        return bus;
    }

    public void setBus(List<RouteOption> bus) {
        this.bus = bus;
    }

    public List<RouteOption> getTrain() {
        return train;
    }

    public void setTrain(List<RouteOption> train) {
        this.train = train;
    }

    // Inner class for individual route options
    public static class RouteOption {
        private String mode; // e.g., "Metro", "Bus", "Train"
        private String duration; // e.g., "30 mins"
        private int cost; // e.g., 50
        private List<String> steps; // Optional step-by-step stops

        public RouteOption() {
        }

        public RouteOption(String mode, String duration, int cost, List<String> steps) {
            this.mode = mode;
            this.duration = duration;
            this.cost = cost;
            this.steps = steps;
        }

        // Getters & Setters
        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public List<String> getSteps() {
            return steps;
        }

        public void setSteps(List<String> steps) {
            this.steps = steps;
        }
    }
}
