package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TrainDto;

import java.util.List;

import com.example.demo.config.FeignConfig;

@FeignClient(name = "train-service", configuration = FeignConfig.class)
public interface TrainClient {
    @GetMapping("/trains")
    List<TrainDto> getAllTrains();

    @PostMapping("/trains")
    TrainDto addTrain(@RequestBody TrainDto train);

    @PutMapping("/trains/{id}")
    TrainDto updateTrain(@PathVariable("id") Integer id, @RequestBody TrainDto train);

    @DeleteMapping("/trains/{id}")
    void deleteTrain(@PathVariable("id") Integer id);
}
