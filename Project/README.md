# JFS-07 — Bus Ticket Reservation System

## 📌 Project Overview

The **Bus Ticket Reservation System** is an advanced transport reservation application designed to manage bus routes, stops, trips, seat availability, passenger bookings, cancellations, refunds, and operational reports.

The system supports three primary roles:

* **Admin**
* **Operator**
* **Passenger**

Operators can create routes, buses, and trip schedules, while passengers can search for trips, view available seats, reserve multiple seats, receive an e-ticket with a PNR, and cancel bookings according to the applicable refund policy.

The project is being developed as part of the **CLG training and project development program**.

---

## 🎯 Project Objectives

The main objectives of this project are:

* Implement a real-world bus ticket reservation workflow.
* Apply Core Java and Object-Oriented Programming principles.
* Design and implement a relational database.
* Build REST APIs using Spring Boot.
* Implement JPA-based persistence.
* Secure APIs using JWT authentication and role-based authorization.
* Handle concurrent seat booking without double-selling seats.
* Implement temporary seat holding and automatic release.
* Apply appropriate Design Patterns.
* Implement cancellation and refund policies.
* Develop reporting functionality for operators and administrators.
* Write unit and API tests.
* Maintain clean Git and Maven project practices.

---

# 👥 User Roles

## 1. Admin

The Admin is responsible for system-level operations and reporting.

### Responsibilities

* Manage users and system access.
* View system reports.
* Monitor route performance.
* View load-factor information.
* Monitor overall revenue.

---

## 2. Operator

The Operator manages the transport-side operations.

### Responsibilities

* Create routes.
* Define stops.
* Create buses.
* Configure bus seating layouts.
* Create trip schedules.
* View bookings.
* Download boarding manifests.
* Monitor revenue and load factor.

---

## 3. Passenger

The Passenger uses the system to reserve bus tickets.

### Responsibilities

* Search available trips.
* View trip details.
* View the live seat map.
* Select multiple seats.
* Provide passenger details.
* Book tickets.
* Receive PNR and e-ticket.
* Cancel bookings.
* Receive refunds according to the applicable refund policy.

---

# 🧩 System Modules

The application is divided into the following modules:

| Module | Name                  | Responsibility                               |
| ------ | --------------------- | -------------------------------------------- |
| M1     | Auth & User           | Authentication, users and roles              |
| M2     | Route & Trip          | Routes, stops, buses and trip schedules      |
| M3     | Seat Booking          | Seat availability, seat hold and booking     |
| M4     | Cancellation & Refund | Cancellation and refund calculation          |
| M5     | Reports               | Revenue, load-factor and operational reports |

---

# 🚍 Core Functional Requirements

### FR1 — Route, Bus and Trip Management

Operators can:

* Create routes.
* Define stops.
* Create buses.
* Configure seats.
* Create trip schedules.

### FR2 — Trip Search

Passengers can search for trips using:

* Source stop
* Destination stop
* Travel date

### FR3 — Live Seat Map

Passengers can view the current seat availability for a trip.

Example:

```text
A1  AVAILABLE     A2  BOOKED

B1  AVAILABLE     B2  HELD

C1  AVAILABLE     C2  AVAILABLE
```

### FR4 — Multiple Seat Booking

A passenger can select multiple seats and provide passenger details for the booking.

### FR5 — PNR & E-Ticket

After successful booking, the system generates:

* Booking
* PNR
* Ticket information
* Seat allocation

### FR6 — Cancellation & Refund

Passengers can cancel eligible bookings.

The refund amount is calculated according to the configured cancellation policy.

### FR7 — Boarding Manifest

Operators can retrieve/download the passenger and seat manifest for a trip.

### FR8 — Reports

Administrators/operators can access:

* Revenue information
* Load-factor information
* Route-level reports

---

# ⚙️ Non-Functional Requirements

The system must satisfy the following requirements:

### Seat Hold

A held seat should automatically become available after **5 minutes** if the booking is not completed.

### Concurrent Booking

The system must prevent two passengers from successfully booking the same seat at the same time.

### Search Performance

Trip search should target a response time of **less than 500 ms**.

### Time Handling

All timestamps should be stored in **UTC** and displayed in **IST** where required.

---

# 🏗️ Planned Architecture

The application will follow a layered and service-oriented architecture.

```text
                         CLIENT
                           │
                           ▼
                    ┌──────────────┐
                    │ API Gateway  │
                    └──────┬───────┘
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ▼                ▼                ▼
   ┌─────────────┐  ┌─────────────┐  ┌─────────────┐
   │auth-service │  │ trip-service│  │booking-     │
   │             │  │             │  │service      │
   └─────────────┘  └─────────────┘  └─────────────┘
          │                │                │
          ▼                ▼                ▼
       Auth DB          Trip DB         Booking DB
```

The architecture will be implemented progressively as the project develops.

---

# 🔄 Main Booking Flow

```text
Passenger
    │
    ▼
Search Trip
    │
    ▼
Select Trip
    │
    ▼
View Seat Map
    │
    ▼
Select Seat(s)
    │
    ▼
Hold Seat
    │
    ▼
Enter Passenger Details
    │
    ▼
Confirm Booking
    │
    ▼
Generate PNR
    │
    ▼
Generate E-Ticket
```

---

# ❌ Cancellation Flow

```text
Passenger
    │
    ▼
Enter PNR
    │
    ▼
Validate Booking
    │
    ▼
Check Cancellation Eligibility
    │
    ▼
Calculate Refund
    │
    ▼
Cancel Booking
    │
    ▼
Release Seats
    │
    ▼
Generate Refund Details
```

---

# 🗃️ Core Database Entities

The initial core entities are:

```text
route
stop
route_stop
bus
seat
trip
booking
booking_seat
passenger
refund
```

The database design will include appropriate:

* Primary keys
* Foreign keys
* Unique constraints
* Check constraints
* Indexes
* Relationships
* Transactions

---

# 🎨 Design Patterns

The project will demonstrate the following design patterns:

## Strategy Pattern

Used for cancellation/refund policies.

```text
RefundPolicy
      │
      ├── Refund calculation based on
      │   hours before departure
      │
      └── Different policy implementations
```

## Factory Pattern

Used for creating bus seat layouts.

```text
SeatLayoutFactory
       │
       ├── Seater Layout
       │
       └── Sleeper Layout
```

## Builder Pattern

Used for constructing ticket objects.

```java
Ticket.builder()
      .pnr(...)
      .passenger(...)
      .trip(...)
      .seat(...)
      .build();
```

---

# ☕ Java Concepts

The project will demonstrate practical usage of:

* Object-Oriented Programming
* Encapsulation
* Abstraction
* Inheritance
* Polymorphism
* Interfaces
* Collections
* Generics
* Exception Handling
* Custom Exceptions
* Java Records
* `java.time`
* `Duration`
* Streams
* `CompletableFuture`
* Multithreading/concurrency concepts

Example immutable seat key:

```java
public record SeatKey(
        Long tripId,
        String seatNumber
) {
}
```

---

# 🌐 Planned REST APIs

### Trip Search

```http
GET /api/v1/trips?from={from}&to={to}&date={date}
```

### Seat Map

```http
GET /api/v1/trips/{id}/seats
```

### Create Booking

```http
POST /api/v1/bookings
```

### Cancel Booking

```http
POST /api/v1/bookings/{pnr}/cancel
```

Additional APIs will be documented as development progresses.

---

# 🔐 Security

The backend will use:

* JWT authentication
* BCrypt password hashing
* Role-based authorization
* Stateless security
* Protected REST endpoints
* Ownership validation where required

Roles:

```text
ADMIN
OPERATOR
PASSENGER
```

The system will distinguish between:

```text
401 Unauthorized
403 Forbidden
```

---

# 🧪 Testing

Testing will be introduced progressively.

Planned technologies:

* JUnit 5
* Mockito
* MockMvc
* Parameterized Tests
* ArgumentCaptor
* Integration testing

The test strategy will cover:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

---

# 📊 Reporting

The reporting module will provide information such as:

### Revenue

```text
Total Revenue
Revenue per Route
Revenue per Trip
```

### Load Factor

```text
Booked Seats
Available Seats
Total Seats
Load Factor
```

The load factor will be calculated using the booking and seat data.

---

# 🛠️ Technology Stack

The technology stack will be introduced progressively during development.

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* REST APIs

### Database

* MySQL

### Communication

* REST
* OpenFeign

### Testing

* JUnit 5
* Mockito
* MockMvc

### Build & Version Control

* Maven
* Git
* GitHub

### Containerization / DevOps

* Docker
* Docker Compose
* CI/CD

Additional technologies will be added as the corresponding project requirements are implemented.

---

# 📁 Project Structure

```text
JFS-07-Bus-Ticket-Reservation-System/
│
├── Daily Task/
│   ├── Day-01/
│   │   └── README.md
│   ├── Day-02/
│   │   └── README.md
│   ├── Day-03/
│   │   └── README.md
│   └── ...
│
└── Project/
    ├── README.md
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        └── test/
            └── java/
```

The `Daily Task` folder records the learning and implementation progress for each training day.

The `Project` folder contains the actual application source code and project documentation.

---

# 📈 Development Approach

The project will be developed incrementally.

```text
Phase 1
Core Java & Domain Model
        ↓
Phase 2
Database Design & SQL
        ↓
Phase 3
Spring Boot REST API
        ↓
Phase 4
JPA & Business Logic
        ↓
Phase 5
JWT Security
        ↓
Phase 6
Testing
        ↓
Phase 7
Microservices & Feign
        ↓
Phase 8
Docker & Deployment
        ↓
Phase 9
Reports & Final Integration
```

---

# 📝 Daily Development Tracking

All daily learning and implementation activities will be maintained under:

```text
Daily Task/
```

Each day will contain a separate `README.md` documenting:

* Objective
* Topics covered
* Work completed
* Technical concepts learned
* Implementation details
* Challenges
* Solutions
* Key learnings
* Git commit
* Current status

This provides a continuous development record for project evaluation and weekly progress reporting.

---

# 🚧 Current Project Status

**Status:** 🟡 Initial Setup / Requirement Analysis

### Completed

* [x] Project requirement identification
* [x] User roles identified
* [x] Core modules identified
* [x] Core database entities identified
* [x] Initial architecture planned
* [x] Development structure created

### In Progress

* [ ] Domain model design
* [ ] Core Java implementation
* [ ] Database schema
* [ ] Spring Boot backend
* [ ] Authentication & authorization
* [ ] Seat booking
* [ ] Cancellation & refund
* [ ] Reports
* [ ] Testing
* [ ] Dockerization

---

# 🎓 Learning & Assessment Alignment

This project is being developed to demonstrate practical understanding of:

* Core Java
* OOP
* Collections
* Generics
* Exception Handling
* SQL
* Database Design
* Spring Boot
* REST APIs
* JPA
* Validation
* JWT Security
* Testing
* Design Patterns
* Microservices
* Docker
* Git & Maven
* Clean Code

The implementation will be developed progressively so that every major feature can be explained, demonstrated, tested, and defended during technical evaluation.

---

# 👨‍💻 Project Development Principle

> **Understand → Design → Implement → Test → Review → Document**

The objective is not only to build a working application, but also to understand the technical decisions behind each component and be able to explain the complete system during project reviews, technical interviews, and assessments.

---

## 📌 Project Information

**Project ID:** JFS-07
**Project Name:** Bus Ticket Reservation System
**Domain:** Transport
**Project Level:** Advanced
**Primary Roles:** Admin, Operator, Passenger
**Development Model:** Incremental / Flow-by-Flow
