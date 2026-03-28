package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.TrainClient;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainClient trainClient;

    public Ticket reserveTicket(Ticket request) {
        // Attempt to deduct 1 seat from the train
        boolean seatUpdated;
        try {
            seatUpdated = trainClient.updateSeats(request.getTrainNumber(), 1);
        } catch (Exception e) {
            throw new RuntimeException("Train Service is currently unavailable or Train '" + request.getTrainNumber() + "' does not exist.");
        }
        
        if (!seatUpdated) {
            throw new RuntimeException("No seats available or Train '" + request.getTrainNumber() + "' not found.");
        }

        // Mock payment verification (credit/debit card assumed verified)
        // Generate PNR
        String pnr = UUID.randomUUID().toString().substring(0, 10).toUpperCase();
        
        request.setPnr(pnr);
        request.setStatus("RESERVED");
        request.setBookingDate(LocalDateTime.now());
        
        return ticketRepository.save(request);
    }
    
    public Ticket cancelTicket(String pnr) {
        Ticket ticket = ticketRepository.findById(pnr)
                .orElseThrow(() -> new RuntimeException("Ticket not found with PNR: " + pnr));
                
        if ("CANCELLED".equals(ticket.getStatus())) {
            throw new RuntimeException("Ticket is already cancelled");
        }

        // Add 1 seat back to the train
        trainClient.updateSeats(ticket.getTrainNumber(), -1);
        
        ticket.setStatus("CANCELLED");
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getUserTickets(Integer userId) {
        return ticketRepository.findByUserId(userId);
    }
    
    public Ticket getTicketByPnr(String pnr) {
        return ticketRepository.findById(pnr)
                .orElseThrow(() -> new RuntimeException("Ticket not found with PNR: " + pnr));
    }
    
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
