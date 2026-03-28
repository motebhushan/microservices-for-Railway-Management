package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.TicketDto;

import java.util.List;

import com.example.demo.config.FeignConfig;

@FeignClient(name = "reservation-service", configuration = FeignConfig.class)
public interface ReservationClient {
    @GetMapping("/tickets")
    List<TicketDto> getAllTickets();
}
