# Railway Reservation System - API Documentation

This document contains all the APIs for testing out the microservices via Postman or cURL.

---

## 1. Auth Service (Port 8082)

**Service Name**: Authentication Service
**API Name**: User Login
**URL**: `POST http://localhost:8082/auth/login`
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

## 2. User Service (Port 8083)

**Service Name**: User Service
**API Name**: Register User
**URL**: `POST http://localhost:8083/auth/register` (or `/users/register`)
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

**Service Name**: User Service
**API Name**: Get All Users
**URL**: `GET http://localhost:8083/users`
**Body**: _None_

**Service Name**: User Service
**API Name**: Get User by ID
**URL**: `GET http://localhost:8083/users/{id}`
**Body**: _None_

---

## 3. Train Service (Port 8084)

**Service Name**: Train Service
**API Name**: Get All Trains
**URL**: `GET http://localhost:8084/trains`
**Body**: _None_

**Service Name**: Train Service
**API Name**: Search Trains by Route
**URL**: `GET http://localhost:8084/trains/search?source=Delhi&destination=Mumbai`
**Body**: _None_

**Service Name**: Train Service
**API Name**: Get Train by ID
**URL**: `GET http://localhost:8084/trains/{id}`
**Body**: _None_

**Service Name**: Train Service
**API Name**: Delete Train (Admin)
**URL**: `DELETE http://localhost:8084/trains/{id}`
**Body**: _None_

**Service Name**: Train Service
**API Name**: Add New Train (Admin)
**URL**: `POST http://localhost:8084/trains`
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
> [!IMPORTANT]
> You **must** include the `"availableSeats"` field in your request. If you omit it, the database will store a `null` value, which will cause the Reservation Service to crash with a `NullPointerException` during booking.

**Service Name**: Train Service
**API Name**: Update Train Details (Admin)
**URL**: `PUT http://localhost:8084/trains/1`
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

## 4. Reservation Service (Port 8085)

**Service Name**: Reservation Service
**API Name**: Reserve Ticket
**URL**: `POST http://localhost:8085/tickets/reserve`
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

**Service Name**: Reservation Service
**API Name**: Cancel Ticket
**URL**: `POST http://localhost:8085/tickets/cancel/{pnr}`
**Body**: _None_

**Service Name**: Reservation Service
**API Name**: Get Ticket by PNR
**URL**: `GET http://localhost:8085/tickets/pnr/{pnr}`
**Example**: `GET http://localhost:8085/tickets/pnr/A1B2C3D4E5`
**Body**: _None_

**Service Name**: Reservation Service
**API Name**: Get Tickets by User
**URL**: `GET http://localhost:8085/tickets/user/1`
**Body**: _None_

**Service Name**: Reservation Service
**API Name**: Get All Tickets
**URL**: `GET http://localhost:8085/tickets`
**Body**: _None_

---

## 5. Admin Service (Port 8086)

**Service Name**: Admin Service
**API Name**: View All Trains
**URL**: `GET http://localhost:8086/admin/trains`
**Body**: _None_

**Service Name**: Admin Service
**API Name**: Add Train
**URL**: `POST http://localhost:8086/admin/trains`
**Body**: Same as Train Service Add Train body.

**Service Name**: Admin Service
**API Name**: Delete Train
**URL**: `DELETE http://localhost:8086/admin/trains/{id}`
**Body**: _None_

**Service Name**: Admin Service
**API Name**: View All Reservations
**URL**: `GET http://localhost:8086/admin/reservations`
**Body**: _None_

**Service Name**: Admin Service
**API Name**: View All Users
**URL**: `GET http://localhost:8086/admin/users`
**Body**: _None_

---

## Eureka Server (Port 8761)
**URL**: `http://localhost:8761/`
(Open in browser to see all registered microservices)
