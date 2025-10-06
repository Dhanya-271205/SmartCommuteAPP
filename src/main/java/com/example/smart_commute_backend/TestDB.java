package com.example.smartcommutebackend;

import com.example.smartcommutebackend.entity.User;
import com.example.smartcommutebackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDB implements CommandLineRunner {

    private final UserRepository userRepository;

    public TestDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        User u = new User();
        u.setName("Pranavi");
        u.setEmail("pranavi@example.com");
        userRepository.save(u);

        System.out.println(userRepository.findAll());
    }
}
