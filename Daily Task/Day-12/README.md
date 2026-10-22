\# Day 12 — Assessment 1: Core Java Checkpoint



\## HCL Java Full Stack Internal Training



\### Project



\*\*Bus Ticket Reservation System\*\*



\### Assessment



\*\*Assessment 1 — Core Java Checkpoint\*\*



\### Branch



`day-12-assessment-1`



\### Tag



`v1.0-core-java`



\---



\## 1. Objective



The objective of Assessment 1 is to integrate the Core Java concepts covered during Days 1–11 into one clean, maintainable console application.



The application implements two complete business flows of the Bus Ticket Reservation System using plain Java.



\---



\# 2. Core Flows



\## Flow 1 — Search Trip and Book Ticket



```text

Passenger

&#x20;   ↓

Search Trip

&#x20;   ↓

Display Available Trips

&#x20;   ↓

Select Trip

&#x20;   ↓

Select Seat

&#x20;   ↓

Validate Seat

&#x20;   ↓

Create Booking

&#x20;   ↓

Generate PNR

```



\## Flow 2 — View and Cancel Booking



```text

Enter PNR

&#x20;   ↓

Find Booking

&#x20;   ↓

Display Booking

&#x20;   ↓

Cancel Booking

&#x20;   ↓

Release Seat

```



\---



\# 3. Core Java Concepts Demonstrated



\## Object-Oriented Programming



The application demonstrates:



\- Encapsulation

\- Abstraction

\- Inheritance

\- Polymorphism

\- Single responsibility

\- Separation of business logic



Main classes:



\- `User`

\- `Passenger`

\- `Operator`

\- `Trip`

\- `Booking`

\- `BookingService`



\---



\## Inheritance and Polymorphism



The application uses:



```text

User

├── Passenger

└── Operator

```



`User` is an abstract class.



Both `Passenger` and `Operator` override:



```java

getRole()

```



This demonstrates runtime polymorphism.



\---



\# 4. Exception Handling



Custom checked exceptions are implemented:



```text

ReservationException

├── SeatNotAvailableException

└── BookingNotFoundException

```



The application handles:



\- Invalid trip

\- Unavailable seat

\- Booking not found

\- Already cancelled booking

\- Invalid numeric input



\---



\# 5. Collections



The application uses:



\### HashMap



Used for PNR-based booking lookup.



```java

Map<String, Booking>

```



\### HashSet



Used for tracking booked seats.



```java

Set<Integer>

```



\### List



Used for returning and processing collections of trips and bookings.



\---



\# 6. Generics



A generic repository abstraction is implemented:



```java

Repository<T>

```



and:



```java

InMemoryRepository<T>

```



The same repository implementation can store different domain objects.



Example:



```java

Repository<Trip>

Repository<Booking>

```



This provides compile-time type safety.



\---



\# 7. Java Fundamentals



The application demonstrates:



\- Variables

\- Methods

\- Conditions

\- Loops

\- Switch expressions

\- Input validation

\- String processing

\- Exception handling

\- Varargs

\- Method references

\- `var`

\- Try-with-resources



\---



\# 8. Memory and Code Quality



The application follows basic memory-aware practices:



\- Objects are created only when required.

\- Fields are encapsulated.

\- Important model fields are immutable using `final`.

\- Collections are not exposed directly for modification.

\- `Scanner` is closed using try-with-resources.

\- Repository results are returned using defensive copies.

\- Business logic is separated from the main application.



\---



\# 9. Maven



The application uses Maven.



Build commands:



```text

mvn clean compile

mvn clean package

```



The generated JAR can be executed using:



```text

java -jar target\\bus-ticket-reservation-day12-1.0.0.jar

```



\---



\# 10. AI Integration



AI was used only as a development assistant.



AI-generated suggestions were reviewed for:



\- Correctness

\- Null safety

\- Exception handling

\- Collection selection

\- Generics

\- Complexity

\- Maintainability



The detailed AI review is available in:



```text

AI-USAGE.md

```



\---



\# 11. Validation Scenarios



The following scenarios were tested:



\### Valid trip search



Input:



```text

Coimbatore

```



Expected:



Available Coimbatore routes are displayed.



\### Valid booking



Input:



```text

Trip: T1001

Seat: 3

```



Expected:



Booking is created and a PNR is generated.



\### Duplicate/unavailable seat



Input:



```text

Seat: 3

```



when already booked.



Expected:



```text

Seat 3 is not available.

```



\### Invalid PNR



Input:



```text

PNR9999

```



Expected:



```text

Booking not found.

```



\### Cancellation



Input:



```text

PNR1001

```



Expected:



Booking status changes to cancelled and the seat is released.



\### Invalid numeric input



Input:



```text

abc

```



Expected:



The application displays an error message instead of crashing.



\---



\# 12. A1 Rubric Mapping



| Area | Marks | Implementation |

|---|---:|---|

| OOP Design | 15 | Encapsulation, abstraction, service separation |

| Inheritance \& Polymorphism | 15 | `User`, `Passenger`, `Operator` |

| Exception Handling | 15 | Custom checked exceptions |

| Collections | 15 | List, Set, Map |

| Generics | 10 | Generic repository |

| Fundamentals \& Correctness | 10 | Input validation, control flow |

| Code Quality \& Memory Awareness | 10 | Immutability, defensive copies, resource handling |

| Git \& Maven | 5 | Maven build, Git branch, merge, tag |

| AI Review | 5 | `AI-USAGE.md` |

| \*\*Total\*\* | \*\*100\*\* | |



\---



\# 13. Assessment Completion Criteria



\- \[x] Two core business flows implemented

\- \[x] OOP principles demonstrated

\- \[x] Inheritance implemented

\- \[x] Polymorphism implemented

\- \[x] Custom exceptions implemented

\- \[x] Collections implemented

\- \[x] Generics implemented

\- \[x] Input validation implemented

\- \[x] Maven build successful

\- \[x] AI review documented

\- \[x] Manual test scenarios completed

\- \[x] Git branch created

\- \[x] Assessment tag created



\---



\# 14. Assessment Result



\*\*Assessment:\*\* A1 — Core Java Checkpoint



\*\*Version:\*\* `v1.0-core-java`



\*\*Status:\*\* Core Java assessment-ready



\*\*Application:\*\* Bus Ticket Reservation System

