# Day 02 — Domain Model & OOP Design

## 📅 Date

06-10-2026

## 🎯 Objective

Design the initial domain model for the **JFS-07 — Bus Ticket Reservation System** and understand how the real-world bus reservation process can be represented using Java classes, interfaces, relationships, and Object-Oriented Programming principles.

The focus of Day 2 is on **design before implementation**.

---

# 📚 Topics Covered

* Domain modelling
* Identifying entities
* Identifying attributes
* Identifying responsibilities
* Class relationships
* Encapsulation
* Abstraction
* Inheritance
* Polymorphism
* Interfaces
* Composition
* Association
* Basic OOP package organization

---

# 👥 Actors Identified

The system contains three primary actors:

### 1. Admin

Responsible for system-level operations and reports.

### 2. Operator

Responsible for:

* Creating routes
* Managing stops
* Creating buses
* Configuring seats
* Creating trips
* Viewing/downloading boarding manifests

### 3. Passenger

Responsible for:

* Searching trips
* Viewing seat availability
* Selecting seats
* Booking tickets
* Cancelling bookings
* Receiving PNR and e-ticket

---

# 🧩 Domain Entities

The following core entities were identified from the project requirements:

```text
Route
Stop
RouteStop
Bus
Seat
Trip
Booking
BookingSeat
Passenger
Refund
```

Additional domain objects such as `Ticket`, `RefundPolicy`, and `SeatLayout` will be introduced where required by the application design.

---

# 🔗 Initial Domain Relationships

The initial relationships between the major entities are:

```text
Route
  │
  └── RouteStop
        │
        └── Stop


Bus
  │
  └── Seat


Route + Bus
     │
     ▼
    Trip
     │
     ▼
  Booking
     │
     ├── BookingSeat
     │
     └── Passenger
```

A trip represents a scheduled bus journey on a particular route using a particular bus.

A booking belongs to a trip and contains one or more booked seats and passenger information.

---

# 🏗️ Initial Class Design

The domain classes are planned around clear responsibilities.

### Route

Represents a bus route.

Possible responsibilities:

* Store route information.
* Maintain route stops.
* Identify the route.

### Stop

Represents a location where passengers can board or leave the bus.

### RouteStop

Represents the association between a route and a stop, including ordering information.

### Bus

Represents a physical bus.

Possible information:

* Bus identifier
* Bus registration information
* Bus type
* Seat layout

### Seat

Represents an individual seat in a bus.

Possible information:

* Seat number
* Seat type
* Seat status

### Trip

Represents a scheduled journey.

Possible information:

* Route
* Bus
* Departure time
* Arrival time
* Fare

### Passenger

Represents a customer travelling on a trip.

### Booking

Represents a passenger's reservation.

Possible information:

* Booking ID
* PNR
* Trip
* Booking status
* Booking time
* Passenger details

### BookingSeat

Represents the relationship between a booking and a particular seat.

### Refund

Represents refund information generated after cancellation.

---

# 🔐 Encapsulation

The domain objects should protect their internal state.

For example, fields should not normally be exposed as public variables.

```java
public class Seat {

    private String seatNumber;
    private SeatStatus status;

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }
}
```

The purpose is to control how the object's state is accessed and modified.

---

# 🧱 Abstraction

Common behaviour can be represented through interfaces or abstract classes.

For example, refund calculation can be abstracted using:

```java
public interface RefundPolicy {

    double calculateRefund(
            double amount,
            long hoursBeforeDeparture
    );
}
```

The booking system does not need to know the internal calculation details.

It only depends on the `RefundPolicy` abstraction.

---

# 🔄 Strategy Pattern — Initial Design

The project requirements specify a **Strategy Pattern** for refund calculation.

Initial design:

```text
             RefundPolicy
                  │
        ┌─────────┴─────────┐
        │                   │
   Refund Strategy 1   Refund Strategy 2
        │                   │
        └─────────┬─────────┘
                  ▼
          Refund Calculation
```

The exact refund slabs will be implemented according to the project requirements and should not be hard-coded until the policy is finalized.

---

# 🏭 Factory Pattern — Initial Design

The project requires a `SeatLayoutFactory` for creating different bus layouts.

Initial design:

```text
SeatLayoutFactory
       │
       ├── Seater Layout
       │
       └── Sleeper Layout
```

This keeps seat-layout creation separate from the rest of the application logic.

---

# 🧱 Builder Pattern — Initial Design

The project requires the Builder pattern for constructing a `Ticket`.

Conceptual design:

```java
Ticket.builder()
      .pnr(...)
      .passenger(...)
      .trip(...)
      .seat(...)
      .build();
```

The actual implementation will be developed during the Core Java implementation phase.

---

# 🪪 SeatKey Record

The project requirements specify the use of a Java `record` for representing a seat key.

Initial design:

```java
public record SeatKey(
        Long tripId,
        String seatNumber
) {
}
```

The `SeatKey` can uniquely identify a seat within a particular trip.

For example:

```text
Trip 101 + A1
Trip 101 + A2
Trip 102 + A1
```

These represent different seat keys.

---

# 📦 Planned Package Structure

The initial Core Java project structure is planned as:

```text
src/
└── main/
    └── java/
        └── com/
            └── jfs07/
                └── bus/
                    ├── model/
                    ├── service/
                    ├── repository/
                    ├── exception/
                    ├── strategy/
                    ├── factory/
                    ├── builder/
                    └── Main.java
```

The package structure may evolve as the project moves from the Core Java prototype to the Spring Boot implementation.

---

# 🔄 Initial Booking Domain Flow

The conceptual booking flow is:

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
Select Seat
    │
    ▼
Hold Seat
    │
    ▼
Create Booking
    │
    ▼
Generate PNR
    │
    ▼
Generate Ticket
```

---

# ⚠️ Important Business Rules Identified

The following rules need to be handled during implementation:

### Seat Hold

A held seat must automatically become available after **5 minutes** if the booking is not completed.

### Double Booking

The system must prevent two passengers from successfully booking the same seat concurrently.

### Time

Times will ultimately be stored in UTC and displayed in IST where required.

### Cancellation

Cancellation must calculate the refund according to the applicable refund policy.

---

# 💡 Key Learning

Today I learned that a real-world application should not be started by directly writing controllers and database code.

The first step is to identify:

```text
Requirements
     ↓
Actors
     ↓
Entities
     ↓
Responsibilities
     ↓
Relationships
     ↓
Business Rules
     ↓
Implementation
```

Good domain modelling helps keep the application maintainable when the project later moves from Core Java to Spring Boot, JPA, and microservices.

---

# 🧠 Interview Questions Prepared

### Q1. Why should fields in a Java class normally be private?

**Answer:**
To achieve encapsulation and prevent uncontrolled modification of an object's internal state.

### Q2. What is the difference between an interface and an abstract class?

**Answer:**
An interface primarily defines a contract that classes can implement, while an abstract class can provide both common state and common behaviour along with abstract methods.

### Q3. Why use the Strategy Pattern for refund calculation?

**Answer:**
Because the refund calculation can vary based on the applicable policy. Strategy allows the calculation algorithm to be changed without modifying the booking service.

### Q4. Why use a Factory for seat layouts?

**Answer:**
To centralize and encapsulate the creation of different seat-layout types instead of spreading object-creation logic throughout the application.

### Q5. Why use a Java record for `SeatKey`?

**Answer:**
A record is suitable for a small immutable data carrier such as a composite key containing `tripId` and `seatNumber`.

---

# 📝 Challenges

* Identifying the correct domain entities.
* Understanding the relationship between `Route`, `Stop`, and `RouteStop`.
* Separating business responsibilities between `Trip`, `Booking`, and `BookingSeat`.
* Understanding where Design Patterns should be applied instead of using them unnecessarily.

---

# ✅ Day 2 Status

### Completed

* [x] Identified primary actors
* [x] Identified core domain entities
* [x] Defined initial entity relationships
* [x] Planned OOP structure
* [x] Identified Strategy Pattern
* [x] Identified Factory Pattern
* [x] Identified Builder Pattern
* [x] Defined `SeatKey` record
* [x] Planned initial package structure
* [x] Documented initial booking flow

### Next

* [ ] Create Maven project
* [ ] Implement domain classes
* [ ] Implement enums
* [ ] Implement interfaces
* [ ] Implement custom exceptions
* [ ] Implement collections
* [ ] Implement initial booking flow
* [ ] Write unit tests

---

# 📌 Git Commit

Suggested commit message:

```text
day-02: design bus reservation domain model and OOP structure
```

---

## 📊 Day 2 Summary

**Focus:** Domain Modelling & OOP Design

**Main Outcome:**
Established the initial domain model, relationships, responsibilities, design-pattern requirements, and package structure for the JFS-07 Bus Ticket Reservation System.

**Status:** Completed
