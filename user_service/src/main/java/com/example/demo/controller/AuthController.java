package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String registerUser(@RequestBody RegisterDto registerDto) {
		User user = new User();
		String username = registerDto.getUsername() != null ? registerDto.getUsername() : registerDto.getEmail();
		user.setUsername(username);
		user.setName(registerDto.getName());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		user.setRole("ROLE_USER");

		userRepository.save(user);
		return "User registered successfully";
	}
}
