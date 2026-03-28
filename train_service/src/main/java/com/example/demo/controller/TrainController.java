package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Train;
import com.example.demo.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Public API for passengers to view all trains
    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    // Public API for passengers to view specific train by ID
    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Integer id) {
        return trainService.getTrainById(id);
    }

    // Public API for passengers to view specific trains
    @GetMapping("/search")
    public List<Train> searchTrains(@RequestParam String source, @RequestParam String destination) {
        return trainService.findTrains(source, destination);
    }

    // Admin API to add a train
    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    // Admin API to update a train
    @PutMapping("/{id}")
    public Train updateTrain(@PathVariable Integer id, @RequestBody Train train) {
        return trainService.updateTrain(id, train);
    }

    // Admin API to delete a train
    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable Integer id) {
        trainService.deleteTrain(id);
    }

    // API to deduct seats (called by reservation_service)
    @PutMapping("/{trainNumber}/updateSeats")
    public boolean updateSeats(@PathVariable String trainNumber, @RequestParam int count) {
        return trainService.updateSeats(trainNumber, count);
    }
}
