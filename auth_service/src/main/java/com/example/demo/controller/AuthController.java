package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtUtil;


@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private JwtUtil jwtUtil;

  
    @Autowired
    private com.example.demo.repository.UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
   

    @PostMapping("/login")
    public org.springframework.http.ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            com.example.demo.model.User user = userRepository.findByUsername(req.getUsername())
                    .orElseThrow(() -> new org.springframework.security.core.userdetails.UsernameNotFoundException("Diagnostic: Username '" + req.getUsername() + "' not found in database"));

            if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
                return org.springframework.http.ResponseEntity.status(401).body("Diagnostic: Password Mismatch for user " + req.getUsername());
            }

            String token = jwtUtil.generateToken(user.getUsername(), user.getRole(), user.getId());
            return org.springframework.http.ResponseEntity.ok(new AuthResponse(token));
        } catch (org.springframework.security.core.userdetails.UsernameNotFoundException e) {
            return org.springframework.http.ResponseEntity.status(401).body(e.getMessage());
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}

