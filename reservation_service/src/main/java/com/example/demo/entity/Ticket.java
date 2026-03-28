package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    private String pnr;

    private Integer userId;
    private String trainNumber;
    
    // Passenger details snapshot
    private String passengerName;
    private Integer age;
    private String sex;

    // "RESERVED" or "CANCELLED"
    private String status;

    private LocalDateTime bookingDate;
    
    private Double farePaid;

    public Ticket() {}

    public Ticket(String pnr, Integer userId, String trainNumber, String passengerName, Integer age, String sex, String status, LocalDateTime bookingDate, Double farePaid) {
        this.pnr = pnr;
        this.userId = userId;
        this.trainNumber = trainNumber;
        this.passengerName = passengerName;
        this.age = age;
        this.sex = sex;
        this.status = status;
        this.bookingDate = bookingDate;
        this.farePaid = farePaid;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Double getFarePaid() {
        return farePaid;
    }

    public void setFarePaid(Double farePaid) {
        this.farePaid = farePaid;
    }
}
