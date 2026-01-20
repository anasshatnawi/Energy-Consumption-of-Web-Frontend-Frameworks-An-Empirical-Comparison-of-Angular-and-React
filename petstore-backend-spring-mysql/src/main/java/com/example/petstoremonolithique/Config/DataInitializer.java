package com.example.petstoremonolithique.Config;

import com.example.petstoremonolithique.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create admin user on startup
        userService.createUser("admin@petstore.com", "admin", passwordEncoder);
        System.out.println("Admin user created: username=admin, password=admin");
    }
}