package com.example.smartcommutebackend.repository;

import com.example.smartcommutebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // explicit annotation to mark it as a Spring bean
public interface UserRepository extends JpaRepository<User, Long> {
    // Optional: custom queries can go here
}
