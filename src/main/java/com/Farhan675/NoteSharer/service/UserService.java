package com.Farhan675.NoteSharer.service;

import com.Farhan675.NoteSharer.model.User;
import com.Farhan675.NoteSharer.repository.UserRepository;
import com.Farhan675.NoteSharer.security.JwtUtil;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {


    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder;


    private JwtUtil jwtUtil = new JwtUtil();

    public User register (User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(username);
    }
}
