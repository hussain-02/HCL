# Day 4 — OOP Concepts + IDE & Debugging

## 1. Objective

The objective of Day 4 is to understand and apply Object-Oriented Programming concepts in the Bus Ticket Reservation System.

The system is converted from procedural-style logic into a class-based design using:

- Classes and Objects
- Encapsulation
- Constructors
- Instance methods
- Access modifiers
- `this` keyword
- Static members
- Abstraction
- Interfaces
- IDE debugging techniques

---

## 2. Project Scenario

The Bus Ticket Reservation System manages:

- Buses
- Routes
- Seats
- Passengers
- Bookings

Each real-world entity is represented as a Java class.

Example:

```text
Bus
 ├── busNumber
 ├── busType
 ├── totalSeats
 └── availableSeats

Route
 ├── source
 ├── destination
 └── distance

Passenger
 ├── passengerId
 ├── name
 └── phoneNumber

Booking
 ├── pnr
 ├── passenger
 ├── route
 └── seatNumber
```

---

## 3. OOP Concepts Applied

| Concept | Application |
|---|---|
| Class | Bus, Route, Passenger, Booking |
| Object | Individual bus/passenger/booking |
| Encapsulation | Private fields with getters/setters |
| Constructor | Initialize objects |
| `this` | Refer to current object |
| Instance method | Object-specific operations |
| Static member | Common system information |
| Abstraction | Reservation operations |
| Interface | Reservation service contract |

---

## 4. Encapsulation

Important data is declared private.

Example:

```java
private String busNumber;
private int totalSeats;
```

Access is provided through methods:

```java
public String getBusNumber() {
    return busNumber;
}

public void setBusNumber(String busNumber) {
    this.busNumber = busNumber;
}
```

This prevents direct uncontrolled modification of object data.

---

## 5. Constructors

Constructors initialize objects when they are created.

Example:

```java
Bus bus = new Bus("TN-01-1234", "AC", 40);
```

---

## 6. Abstraction

Reservation operations are represented using an interface.

Example:

```java
public interface ReservationService {

    void bookTicket();

    void cancelTicket();

    void viewBooking();
}
```

The interface defines what the system should do without specifying the complete implementation.

---

## 7. Debugging

The application is debugged using IntelliJ IDEA.

Debugging activities:

1. Set breakpoint.
2. Start application in Debug mode.
3. Inspect variables.
4. Use Step Over.
5. Use Step Into.
6. Use Step Out.
7. Inspect Call Stack.
8. Identify logical errors.
9. Resume execution.

---

## 8. Debugging Scenario

Example:

```java
int availableSeats = 10;

if (availableSeats > 0) {
    availableSeats--;
}

System.out.println(availableSeats);
```

A breakpoint can be placed before the condition to inspect:

```text
availableSeats = 10
```

After execution:

```text
availableSeats = 9
```

---

## 9. Expected Outcome

By the end of Day 4:

- The project uses proper Java classes.
- Fields are encapsulated.
- Constructors initialize objects.
- Methods represent object behavior.
- Basic abstraction is introduced.
- Debugging techniques are practiced.
- Maven build succeeds.

---

## 10. Evidence

Required evidence:

- Project class structure
- Bus object creation
- Encapsulation code
- Constructor usage
- Interface implementation
- Debug breakpoint
- Debug variable inspection
- Successful Maven build

---

## 11. HCL Readiness Checklist

- [ ] Explain class vs object
- [ ] Explain encapsulation
- [ ] Explain constructor
- [ ] Explain `this`
- [ ] Explain static vs instance
- [ ] Explain abstraction
- [ ] Explain interface
- [ ] Set breakpoint
- [ ] Explain Step Over vs Step Into
- [ ] Explain Call Stack
- [ ] Run `mvn clean package`
- [ ] Commit changes to Git

---

## 12. Git Commit

Example:

```text
Day 4: Implement OOP design and debugging
```