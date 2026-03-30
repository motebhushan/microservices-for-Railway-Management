# Railway Reservation System - API Documentation

This document contains all the APIs for testing out the microservices. 

> [!IMPORTANT]
> All requests should be directed to the **API Gateway** (Port **8080**). The Gateway will automatically route your requests to the correct underlying microservice.

---

## Central Entry Point: API Gateway (Port 8080)
**Base URL**: `http://localhost:8080`

---

## 1. Auth Service
**API Name**: User Login
**URL**: `POST http://localhost:8080/auth/login`
**Body**: 
```json
{
  "username": "jane@example.com",
  "password": "password123"
}
```
> [!NOTE]
> You can use either the `username` you registered with or your `email` address in the `username` field for login.

---

## 2. User Service
**API Name**: Register User
**URL**: `POST http://localhost:8080/auth/register`
**Body**:
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "username": "janedoe",
  "password": "password123"
}
```
> [!TIP]
> The `username` field is now optional. If you omit it, your `email` will be used as your username for login.

**API Name**: Get All Users
**URL**: `GET http://localhost:8080/users`
**Body**: _None_

**API Name**: Get User by ID
**URL**: `GET http://localhost:8080/users/{id}`
**Body**: _None_

---

## 3. Train Service
**API Name**: Get All Trains
**URL**: `GET http://localhost:8080/trains`
**Body**: _None_

**API Name**: Search Trains by Route
**URL**: `GET http://localhost:8080/trains/search?source=Delhi&destination=Mumbai`
**Body**: _None_

**API Name**: Get Train by ID
**URL**: `GET http://localhost:8080/trains/{id}`
**Body**: _None_

**API Name**: Delete Train (Admin)
**URL**: `DELETE http://localhost:8080/trains/{id}`
**Body**: _None_

**API Name**: Add New Train (Admin)
**URL**: `POST http://localhost:8080/trains`
**Body**:
```json
{
  "trainNumber": "12345",
  "trainName": "Rajdhani Express",
  "source": "Delhi",
  "destination": "Mumbai",
  "departureTime": "10:00:00",
  "arrivalTime": "22:00:00",
  "totalSeats": 500,
  "availableSeats": 500,
  "ticketFare": 1500.50
}
```

**API Name**: Update Train Details (Admin)
**URL**: `PUT http://localhost:8080/trains/1`
**Body**:
```json
{
  "trainName": "Rajdhani Express",
  "source": "Delhi",
  "destination": "Mumbai",
  "departureTime": "10:30:00",
  "arrivalTime": "22:30:00",
  "totalSeats": 600,
  "availableSeats": 600,
  "ticketFare": 1600.00
}
```

---

## 4. Reservation Service
**API Name**: Reserve Ticket
**URL**: `POST http://localhost:8080/tickets/reserve`
**Body**:
```json
{
  "userId": 1,
  "trainNumber": "12345",
  "passengerName": "John Doe",
  "age": 30,
  "sex": "Male",
  "farePaid": 1500.50
}
```

**API Name**: Cancel Ticket
**URL**: `POST http://localhost:8080/tickets/cancel/{pnr}`
**Body**: _None_

**API Name**: Get Ticket by PNR
**URL**: `GET http://localhost:8080/tickets/pnr/{pnr}`
**Example**: `GET http://localhost:8080/tickets/pnr/A1B2C3D4E5`
**Body**: _None_

**API Name**: Get Tickets by User
**URL**: `GET http://localhost:8080/tickets/user/1`
**Body**: _None_

**API Name**: Get All Tickets
**URL**: `GET http://localhost:8080/tickets`
**Body**: _None_

---

## 5. Admin Service
**API Name**: View All Trains
**URL**: `GET http://localhost:8080/admin/trains`
**Body**: _None_

**API Name**: Add Train
**URL**: `POST http://localhost:8080/admin/trains`
**Body**: Same as Train Service Add Train body.

**API Name**: Delete Train
**URL**: `DELETE http://localhost:8080/admin/trains/{id}`
**Body**: _None_

**API Name**: View All Reservations
**URL**: `GET http://localhost:8080/admin/reservations`
**Body**: _None_

**API Name**: View All Users
**URL**: `GET http://localhost:8080/admin/users`
**Body**: _None_

---

## Eureka Server (Port 8761)
**URL**: `http://localhost:8761/`
(Open in browser to see all registered microservices)
