package com.sim.config;

import com.sim.model.AccountType;
import com.sim.model.Role;
import com.sim.model.User;
import com.sim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("owner").isEmpty()) {
            User owner = new User();
            owner.setUsername("owner");
            owner.setPasswordHash(passwordEncoder.encode("chain55")); // Development only
            owner.setUid("AD000000"); // Hardcoded strict owner UID for dev
            owner.setAccountType(AccountType.ADMIN);
            owner.setRole(Role.OWNER);
            owner.setActive(true);
            owner.setCreatedAt(Instant.now());
            userRepository.save(owner);
            System.out.println("Created development OWNER user (UID: AD000000).");
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPasswordHash(passwordEncoder.encode("admin"));
            admin.setUid("AD000001");
            admin.setAccountType(AccountType.ADMIN);
            admin.setRole(Role.ADMIN);
            admin.setActive(true);
            admin.setCreatedAt(Instant.now());
            userRepository.save(admin);
            System.out.println("Created development ADMIN user (UID: AD000001).");
        }
    }
}