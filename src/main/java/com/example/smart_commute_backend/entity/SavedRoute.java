package com.example.smartcommutebackend.entity;

import jakarta.persistence.*;

@Entity
public class SavedRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;
    private String routeDetails; // e.g., JSON or description

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // link to User

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public String getRouteDetails() { return routeDetails; }
    public void setRouteDetails(String routeDetails) { this.routeDetails = routeDetails; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
