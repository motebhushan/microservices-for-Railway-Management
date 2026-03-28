package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Ticket;
import com.example.demo.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Passenger API to reserve a ticket (which internally handles mock payment)
    @PostMapping("/reserve")
    public org.springframework.http.ResponseEntity<?> reserveTicket(@RequestBody Ticket request) {
        try {
            Ticket ticket = reservationService.reserveTicket(request);
            return org.springframework.http.ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return org.springframework.http.ResponseEntity.status(400).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.status(500).body("Unexpected Internal Server Error: " + e.getMessage());
        }
    }

    // Passenger API to cancel a ticket
    @PostMapping("/cancel/{pnr}")
    public Ticket cancelTicket(@PathVariable String pnr) {
        return reservationService.cancelTicket(pnr);
    }

    // API to view tickets of a specific user
    @GetMapping("/user/{userId}")
    public List<Ticket> getUserTickets(@PathVariable Integer userId) {
        return reservationService.getUserTickets(userId);
    }

    // API to view a specific ticket by its PNR
    @GetMapping("/pnr/{pnr}")
    public Ticket getTicketByPnr(@PathVariable String pnr) {
        return reservationService.getTicketByPnr(pnr);
    }

    // Admin API to view all tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return reservationService.getAllTickets();
    }
}
