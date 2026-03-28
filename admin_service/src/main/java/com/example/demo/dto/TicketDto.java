package com.example.demo.dto;

import java.time.LocalDateTime;

public class TicketDto {
    private String pnr;
    private Integer userId;
    private String trainNumber;
    private String passengerName;
    private Integer age;
    private String sex;
    private String status;
    private LocalDateTime bookingDate;
    private Double farePaid;

    // Getters and Setters
    public String getPnr() { return pnr; }
    public void setPnr(String pnr) { this.pnr = pnr; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getTrainNumber() { return trainNumber; }
    public void setTrainNumber(String trainNumber) { this.trainNumber = trainNumber; }
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    public Double getFarePaid() { return farePaid; }
    public void setFarePaid(Double farePaid) { this.farePaid = farePaid; }
}
