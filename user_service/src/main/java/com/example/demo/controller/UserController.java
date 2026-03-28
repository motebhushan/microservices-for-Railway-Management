package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.dto.RegisterDto;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@GetMapping
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}

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
