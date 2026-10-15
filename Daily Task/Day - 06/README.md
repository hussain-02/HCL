\# Day 6 — Exception Handling + AI-Assisted Debugging



\## Objective



Implement robust exception handling in the Bus Ticket Reservation System and practice AI-assisted debugging.



\## Topics



\- Exception hierarchy

\- Checked exceptions

\- Unchecked exceptions

\- try-catch

\- finally

\- throw

\- throws

\- Multiple catch

\- Custom exceptions

\- Input validation

\- Exception propagation

\- AI-assisted debugging



\## Project Scenario



The reservation system must safely handle:



\- Invalid seat numbers

\- Unavailable seats

\- Invalid passenger information

\- Duplicate booking

\- Cancellation without an active booking



The application should display meaningful messages instead of crashing.



\## Exception Hierarchy



```text

RuntimeException

&#x20;      |

ReservationException

&#x20;      |

&#x20;  +---+----------------+

&#x20;  |                    |

SeatNotAvailable   InvalidBooking

```



\## Implementation



Custom exceptions are used to represent reservation-specific failures.



`try-catch` is used to handle expected failures.



`finally` is used for operations that should execute after exception processing.



`throw` is used to explicitly raise an exception.



`throws` is used to declare an exception in a method signature.



\## AI-Assisted Debugging



An intentional NullPointerException was introduced and analyzed using AI.



Problem:



```java

String pnr = null;



if (pnr.equals("PNR1001")) {

&#x20;   System.out.println("Booking found");

}

```



Safer implementation:



```java

if ("PNR1001".equals(pnr)) {

&#x20;   System.out.println("Booking found");

}

```



The AI recommendation was reviewed and tested before acceptance.



\## Expected Outcome



\- Application handles expected errors.

\- Custom exceptions are implemented.

\- Invalid operations do not crash the application.

\- Exception concepts are understood.

\- AI-generated fixes are reviewed before use.



\## Evidence



\- Custom exception classes

\- try-catch

\- finally

\- throw

\- throws

\- Exception output

\- AI debugging

\- Corrected code

\- Maven BUILD SUCCESS

\- Git branch and commit



\## Git Commit



```text

Day 6: Implement exception handling and AI-assisted debugging

```

