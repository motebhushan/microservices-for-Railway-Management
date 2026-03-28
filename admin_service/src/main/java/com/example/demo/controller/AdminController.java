package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.client.ReservationClient;
import com.example.demo.client.TrainClient;
import com.example.demo.client.UserClient;
import com.example.demo.dto.TicketDto;
import com.example.demo.dto.TrainDto;
import com.example.demo.dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TrainClient trainClient;

    @Autowired
    private ReservationClient reservationClient;

    @Autowired
    private UserClient userClient;

    // ----- Train Management ----- //

    @GetMapping("/trains")
    public List<TrainDto> viewAllTrains() {
        return trainClient.getAllTrains();
    }

    @PostMapping("/trains")
    public TrainDto addTrain(@RequestBody TrainDto train) {
        return trainClient.addTrain(train);
    }

    @PutMapping("/trains/{id}")
    public TrainDto updateTrain(@PathVariable Integer id, @RequestBody TrainDto train) {
        return trainClient.updateTrain(id, train);
    }

    @DeleteMapping("/trains/{id}")
    public void deleteTrain(@PathVariable Integer id) {
        trainClient.deleteTrain(id);
    }


    // ----- Reservation Management ----- //

    @GetMapping("/reservations")
    public List<TicketDto> viewAllReservations() {
        return reservationClient.getAllTickets();
    }


    // ----- Passenger / User Management ----- //

    @GetMapping("/users")
    public List<UserDto> viewAllUsers() {
        return userClient.getAllUsers();
    }

}
