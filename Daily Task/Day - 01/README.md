# Day 1 — Java Platform Basics + Agile/Scrum Basics

## 📅 Date

05-10-2026

## 🎯 Objective

The objective of Day 1 was to understand the fundamentals of the Java platform and the basic principles of Agile/Scrum methodology used in software development teams.

The day also included a practical Java program to understand Java runtime information, compilation, bytecode and JVM class loading.

---

# ☕ 1. Java Platform Basics

## JVM — Java Virtual Machine

The **JVM (Java Virtual Machine)** is responsible for running Java bytecode.

Java source code is compiled into bytecode, and the JVM executes that bytecode.

### Key Point

The JVM is platform-dependent because different operating systems have different JVM implementations.

Examples:

- Windows JVM
- Linux JVM
- macOS JVM

However, the Java bytecode remains the same.

---

## JRE — Java Runtime Environment

The **JRE (Java Runtime Environment)** contains:

```text
JRE
 ├── JVM
 └── Java Runtime Libraries
```

Its primary purpose is to provide the environment required to **run Java applications**.

---

## JDK — Java Development Kit

The **JDK (Java Development Kit)** contains the tools required to develop and run Java applications.

Conceptually:

```text
JDK
 ├── JRE
 │    ├── JVM
 │    └── Libraries
 │
 └── Development Tools
      ├── javac
      ├── java
      └── javap
```

### Important Commands

| Command | Purpose |
|---|---|
| `javac` | Compiles Java source code |
| `java` | Runs a Java application |
| `javap` | Inspects/disassembles compiled bytecode |

---

# ⚙️ 2. JVM Architecture

The basic JVM execution flow studied today:

```text
.java
  │
  ▼
javac Compiler
  │
  ▼
.class Bytecode
  │
  ▼
Class Loader
  │
  ▼
Bytecode Verifier
  │
  ▼
Execution Engine
  │
  ├── Interpreter
  │
  └── JIT Compiler
  │
  ▼
Machine-Level Execution
```

## Class Loader

The Class Loader loads required `.class` files into the JVM.

## Bytecode Verifier

The Bytecode Verifier checks the loaded bytecode for correctness and helps maintain JVM safety.

## Execution Engine

The Execution Engine executes the bytecode.

It includes:

- Interpreter
- JIT Compiler

### Interpreter

The Interpreter executes bytecode instructions.

### JIT Compiler

The **Just-In-Time (JIT) Compiler** identifies frequently executed code and compiles it into optimized machine code during runtime.

---

# 🔄 3. Java Program Execution Flow

The Java execution flow studied today:

```text
PlatformInfo.java
       │
       │ javac
       ▼
PlatformInfo.class
       │
       │ JVM
       ▼
Bytecode Execution
       │
       ▼
Machine-Level Execution
```

This demonstrates the fundamental reason Java applications can run across different operating systems while using the same compiled bytecode.

---

# 🌱 4. Agile / Scrum Basics

Today I also learned the basic concepts of Agile and Scrum.

## Sprint

A **Sprint** is a fixed time-box during which a usable product increment is developed.

A Sprint is usually **2–4 weeks**.

---

## Daily Standup

A Daily Standup is a short daily meeting, generally around 15 minutes.

The three main questions are:

1. What did I do yesterday?
2. What will I do today?
3. Do I have any blockers?

Example:

```text
Yesterday:
Completed Java platform basics.

Today:
Work on project/domain analysis.

Blocker:
No current blocker.
```

---

## Retrospective

A Retrospective is conducted at the end of a Sprint to improve the team's working process.

Typical discussion:

```text
What went well?
        ↓
What did not go well?
        ↓
What can we improve?
        ↓
Action items
```

---

## User Story

A User Story describes a requirement from the user's perspective.

General format:

```text
As a [role],
I want [feature],
so that [benefit].
```

### Example for JFS-07

```text
As a passenger,
I want to search for available bus trips
between two stops on a selected date,
so that I can choose a suitable trip.
```

---

## Story Points

Story Points are used to estimate the **relative effort/complexity** of a task.

A commonly used sequence is:

```text
1 → 2 → 3 → 5 → 8 → 13
```

Story points are not direct time measurements.

---

## Definition of Done (DoD)

The **Definition of Done** is the checklist that must be satisfied before a User Story is considered complete.

A DoD may include:

```text
Code implemented
       ↓
Code reviewed
       ↓
Tests passed
       ↓
No known critical issues
       ↓
Documentation updated
       ↓
Story accepted
```

---

# 💻 5. Practical Work

## Program

### `PlatformInfo.java`

The practical task was to create a Java program that displays Java platform and system information.

The program prints information such as:

- Java version
- Operating system
- Number of processors
- Maximum heap memory
- Free heap memory

---

# ▶️ 6. How to Run

Compile the Java program:

```bash
javac PlatformInfo.java
```

Run the program:

```bash
java PlatformInfo
```

Inspect the generated bytecode:

```bash
javap -c PlatformInfo
```

Run with verbose class-loading information:

```bash
java -verbose:class PlatformInfo
```

---

# 📤 7. Expected Output

```text
=== Java Platform Information ===
Java Version  : 17.0.x
OS Name       : Windows 11
Processors    : 8
Max Heap (MB) : 2048
Free Heap (MB): 245
```

> The actual Java version, operating system, processor count and memory values depend on the machine on which the program is executed.

---

# 🔍 8. Important Commands

## `javac`

Compiles Java source code into bytecode.

```bash
javac PlatformInfo.java
```

Result:

```text
PlatformInfo.java
       ↓
PlatformInfo.class
```

---

## `java`

Runs the compiled Java application.

```bash
java PlatformInfo
```

---

## `javap -c`

Displays the disassembled bytecode generated by the Java compiler.

```bash
javap -c PlatformInfo
```

This helps understand what bytecode instructions were generated from the Java source code.

---

## `java -verbose:class`

Displays class-loading information while the Java application runs.

```bash
java -verbose:class PlatformInfo
```

This helps observe classes being loaded by the JVM at runtime.

---

# 🧠 9. Key Learnings

### Java

- Understood the difference between JDK, JRE and JVM.
- Understood the Java source-to-bytecode execution flow.
- Learned the basic JVM architecture.
- Understood the role of the Class Loader.
- Understood the purpose of Bytecode Verification.
- Learned the role of the Execution Engine.
- Understood the basic difference between the Interpreter and JIT Compiler.
- Practiced `javac`, `java`, `javap -c` and `java -verbose:class`.

### Agile / Scrum

- Understood the purpose of a Sprint.
- Learned the three Daily Standup questions.
- Understood the purpose of Sprint Retrospectives.
- Learned the structure of a User Story.
- Understood Story Points and relative estimation.
- Learned the purpose of a Definition of Done.

---

# 🔗 10. Connection to JFS-07 Project

The concepts learned today will support the development of the **JFS-07 Bus Ticket Reservation System**.

For example, the User Story format can be applied to project requirements:

```text
As a passenger,
I want to view available seats for a trip,
so that I can select the seats I want to book.
```

The Agile concepts will also be used to organize the project into smaller development tasks and daily progress.

The Java platform knowledge provides the foundation for the Core Java implementation and the later Spring Boot backend.

---

# 🚧 Challenges / Questions for Further Study

The following topics require deeper understanding during the upcoming training:

- JVM memory areas
- Heap vs Stack
- Garbage Collection
- Class Loader hierarchy
- JIT compilation in more detail
- Java compilation and bytecode instructions
- How Java achieves platform independence
- Applying Scrum concepts to the actual project

---

# ✅ Day 1 Status

**Status: COMPLETED**

### Completed

- [x] Java Platform Basics
- [x] JVM, JRE and JDK
- [x] JVM execution flow
- [x] Basic JVM architecture
- [x] Agile/Scrum fundamentals
- [x] Sprint
- [x] Daily Standup
- [x] Retrospective
- [x] User Stories
- [x] Story Points
- [x] Definition of Done
- [x] `PlatformInfo.java` practical
- [x] Java compilation and execution commands
- [x] Bytecode inspection using `javap`
- [x] JVM class-loading observation

---

# 🔜 Next Step

Continue with the next training day's topics and update the corresponding daily task folder.

**Development principle:**

```text
Learn
  ↓
Understand
  ↓
Practice
  ↓
Apply to JFS-07
  ↓
Document
  ↓
Commit to Git
```
