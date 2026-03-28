package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("register")
	public String rgisterUser(@RequestBody RegisterDto registerDto) {
		return "success";
	}
}
