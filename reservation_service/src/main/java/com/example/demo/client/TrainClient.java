package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.config.FeignConfig;

import com.example.demo.config.FeignConfig;

@FeignClient(name = "train-service", configuration = FeignConfig.class)
public interface TrainClient {
    @PutMapping("/trains/{trainNumber}/updateSeats")
    boolean updateSeats(@PathVariable("trainNumber") String trainNumber, @RequestParam("count") int count);
}
