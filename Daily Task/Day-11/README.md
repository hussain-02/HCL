\# Day 11 — AI Integration (Core Java)



\## HCL Java Fullstack Internal Training



\### Objective



Learn how to use AI tools responsibly during Core Java development.



The goal is not to blindly accept AI-generated code.



The developer must:



1\. Write the requirement clearly.

2\. Ask AI for a possible implementation.

3\. Review the generated code.

4\. Identify bugs or design issues.

5\. Correct the implementation.

6\. Compile and test the code.

7\. Explain the final implementation independently.



\---



\## Topics Covered



\- AI-assisted Java development

\- AI-generated code review

\- Identifying incorrect AI suggestions

\- Null safety

\- Collection selection

\- Exception handling

\- Generics

\- Stream API

\- Object-oriented design

\- Time and space complexity

\- Code readability

\- AI validation

\- Human review of AI-generated code



\---



\## Project Context



The examples are based on the Bus Ticket Reservation System.



The system contains concepts such as:



\- Passenger

\- Bus

\- Route

\- Booking

\- PNR

\- Seat

\- Waiting List

\- Booking validation



\---



\## AI Review Workflow



Requirement

↓

AI-generated solution

↓

Developer review

↓

Identify issues

↓

Correct code

↓

Compile

↓

Test

↓

Document correction



\---



\## AI Review Exercises



\### Exercise 1 — Null Safety



Review an AI-generated PNR lookup implementation.



Potential problem:



```java

String pnr = null;



if (pnr.equals("PNR1001")) {

&#x20;   System.out.println("Booking found");

}

