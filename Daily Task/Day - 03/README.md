# Day 3 — Control Flow + Maven Fundamentals

## Bus Ticket Reservation Scenario

**Bus Ticket Reservation Console** — A console-based reservation menu for managing routes, searching trips, viewing seat availability, booking/cancelling tickets, and generating basic reports.

The objective is to demonstrate Java control-flow concepts while converting the project into a standard Maven project.

---

## Files

```text
Daily Task/Day-3/
  pom.xml
  README.md

  src/main/java/com/hussain/bus/
    BusReservationApp.java       ← main class, menu and control flow
    Route.java                   ← route POJO
    Bus.java                     ← bus POJO
    Seat.java                    ← seat POJO
    Passenger.java               ← passenger POJO

  src/main/resources/
    application.properties       ← environment configuration

  src/test/java/
    (placeholder for future tests)
```

---

## Control Flow Concepts Used

| **Concept**      | **Where**                                                                         |
| ---------------- | --------------------------------------------------------------------------------- |
| `do-while`       | Main menu — repeatedly displays the menu until the user selects Exit              |
| `while(true)`    | Continuous reservation menu loop                                                  |
| `switch`         | Menu options such as Search Trip, View Seats, Book Ticket, Cancel Ticket and Exit |
| `if/else`        | Input validation, seat availability, booking validation and cancellation checks   |
| `for`            | Iterating through seat inventory and available trips                              |
| enhanced `for`   | Displaying routes, buses, seats and booking information                           |
| `continue`       | Skip invalid input or unavailable seats while displaying available options        |
| `break`          | Exit the menu loop or stop searching once the required trip/seat is found         |
| labelled `break` | Exit a nested search operation and return to the main menu when required          |

---

## Console Menu

```text
========================================
     BUS TICKET RESERVATION SYSTEM
========================================

1. View Routes
2. Search Trips
3. View Available Seats
4. Book Ticket
5. Cancel Ticket
6. View Booking / PNR
7. Generate Boarding Manifest
8. Revenue Report
9. Exit

Enter your choice:
```

Each menu option is handled using a `switch` statement.

---

## Control Flow Examples

### 1. Main Menu

The application uses a `do-while` loop so that the menu is displayed at least once.

```text
Display Menu
     ↓
Read Choice
     ↓
switch(choice)
     ↓
Execute Operation
     ↓
choice != 9 ?
     ↓
Yes → Display Menu Again
No  → Exit
```

### 2. Search Trips

The application uses a `for` / enhanced `for` loop to search through available trips.

```text
Enter Source
Enter Destination
       ↓
Iterate through trips
       ↓
Matching source + destination?
       ↓
Yes → Display trip
No  → Continue searching
```

### 3. Seat Availability

The application checks each seat using `if/else`.

```text
Seat available?
     ↓
Yes → Display seat
No  → continue
```

### 4. Booking Validation

Before booking:

```text
Passenger valid?
       ↓
Trip exists?
       ↓
Seat exists?
       ↓
Seat available?
       ↓
Yes → Confirm booking
No  → Display error
```

---

# Maven Concepts Used

| **Concept**        | **Notes**                                                            |
| ------------------ | -------------------------------------------------------------------- |
| Standard structure | `src/main/java`, `src/main/resources`, `src/test/java`               |
| Coordinates        | `com.hussain:bus-ticket-reservation:1.0.0`                           |
| Properties         | `maven.compiler.release=21`, `environment`                           |
| Resource filtering | `environment=${environment}` replaced during Maven build             |
| Lifecycle          | `mvn clean package` → validate → compile → test → package            |
| Profiles           | `-Pdev` → development environment; `-Pprod` → production environment |
| maven-jar-plugin   | Configures `Main-Class` so the JAR can run using `java -jar`         |
| Dependency scopes  | Understand `compile`, `test`, `provided`, and `runtime` scopes       |
| Packaging          | Application is packaged as an executable JAR                         |

---

## Maven Project Structure

```text
bus-ticket-reservation/
│
├── pom.xml
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/hussain/bus/
    │   └── resources/
    │       └── application.properties
    │
    └── test/
        └── java/
```

---

## Maven Lifecycle

```text
validate
   ↓
compile
   ↓
test
   ↓
package
   ↓
verify
   ↓
install
   ↓
deploy
```

For Day 3, the primary command is:

```bash
mvn clean package
```

---

## Maven Profiles

### Development

```bash
mvn clean package -Pdev
```

Configuration:

```text
environment=dev
```

### Production

```bash
mvn clean package -Pprod
```

Configuration:

```text
environment=prod
```

The packaged application should display:

```text
[DEV] Bus Ticket Reservation System
```

or:

```text
[PROD] Bus Ticket Reservation System
```

depending on the Maven profile used.

---

## How to Run

From the Day 3 directory:

```bash
cd "Daily Task/Day-3"
```

Build using the development profile:

```bash
mvn clean package -Pdev
```

Run the generated JAR:

```bash
java -jar target/bus-ticket-reservation-1.0.0.jar
```

For production:

```bash
mvn clean package -Pprod
java -jar target/bus-ticket-reservation-1.0.0.jar
```

---

## Functional Requirements Covered

The Day 3 console menu provides one option for each major project flow:

| **FR** | **Feature**            | **Day 3 Status**                 |
| ------ | ---------------------- | -------------------------------- |
| FR1    | Manage Routes          | Console option created           |
| FR2    | Manage Stops           | Console option/flow prepared     |
| FR3    | Search Trips           | Basic console flow implemented   |
| FR4    | View Seat Availability | Basic inventory flow implemented |
| FR5    | Hold/Book Seat         | Basic validation flow prepared   |
| FR6    | Cancel Booking         | Basic cancellation flow prepared |
| FR7    | View PNR / Booking     | Console option created           |
| FR8    | Reports                | Console option created           |

> Day 3 focuses on **control flow and Maven**, not complete business implementation of every feature.

---

# Git Work

Meaningful commits should be created instead of pushing everything in one commit.

Example:

```bash
git add .
git commit -m "feat: create Maven project structure"
```

```bash
git add .
git commit -m "feat: add bus reservation console menu"
```

```bash
git add .
git commit -m "feat: implement control flow for reservation menu"
```

Push:

```bash
git push
```

---

# Evidence / Screenshots

The following evidence should be added to the Day 3 documentation:

1. Maven project structure
2. `pom.xml`
3. Console menu running
4. `switch` menu execution
5. Invalid input handling
6. Trip search output
7. Seat availability output
8. `mvn clean package` showing `BUILD SUCCESS`
9. Development profile build
10. Production profile build
11. `java -jar` execution
12. Git commit history

---

# Day 3 Learning Outcomes

By the end of Day 3, I should be able to:

- Explain all major Java control-flow statements.
- Choose between `if/else` and `switch`.
- Explain `while` vs `do-while`.
- Explain `for` vs enhanced `for`.
- Explain `break` vs `continue`.
- Use labelled `break` when appropriate.
- Create a standard Maven project.
- Explain the purpose of `pom.xml`.
- Explain Maven coordinates.
- Explain Maven dependencies.
- Explain Maven lifecycle phases.
- Run Maven commands from the terminal.
- Create and use Maven profiles.
- Package a Java application into a JAR.
- Run the JAR using `java -jar`.
- Maintain the project using meaningful Git commits.

---

# HCL Assessment Readiness

### Control Flow

- [ ] `if/else`
- [ ] `switch`
- [ ] `while`
- [ ] `do-while`
- [ ] `for`
- [ ] enhanced `for`
- [ ] `break`
- [ ] `continue`
- [ ] labelled `break`

### Maven

- [ ] Standard Maven structure
- [ ] `pom.xml`
- [ ] Maven coordinates
- [ ] Dependencies
- [ ] Dependency scopes
- [ ] Maven lifecycle
- [ ] Maven profiles
- [ ] Resource filtering
- [ ] Maven packaging
- [ ] Executable JAR

### Project

- [ ] Bus reservation Maven project created
- [ ] Console menu implemented
- [ ] FR-based menu options created
- [ ] Input validation added
- [ ] Maven build successful
- [ ] DEV profile tested
- [ ] PROD profile tested
- [ ] JAR executed successfully
- [ ] Meaningful Git commits pushed
