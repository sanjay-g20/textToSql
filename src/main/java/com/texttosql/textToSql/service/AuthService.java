package com.texttosql.textToSql.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.texttosql.textToSql.model.User;
import com.texttosql.textToSql.repository.UserRepository;

@Component
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ResponseEntity<String> createUser(User input) {
        if (userRepository.findByUsername(input.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        } else {
            User user = new User();
            user.setUsername(input.getUsername());
            user.setPassword(passwordEncoder.encode(input.getPassword()));
            user.setRole(input.getRole());
            try {
                userRepository.save(user);
                return ResponseEntity.ok("User created successfully");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(String.format("Error while creating user %s", e.getMessage()));
            }
        }
    }
}
