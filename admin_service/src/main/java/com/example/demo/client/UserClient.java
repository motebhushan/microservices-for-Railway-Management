package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.UserDto;

import java.util.List;

import com.example.demo.config.FeignConfig;

@FeignClient(name = "user-service", configuration = FeignConfig.class)
public interface UserClient {
    @GetMapping("/users")
    List<UserDto> getAllUsers();
}
