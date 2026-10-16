\# Day 10 — Java Memory Management



\## Objective



Understand Java memory management and apply memory-aware programming practices to the Bus Ticket Reservation System.



\## Topics



\- Stack memory

\- Heap memory

\- Objects

\- References

\- String pool

\- Garbage Collection

\- Reachability

\- Object lifetime

\- `null`

\- Memory leaks

\- OutOfMemoryError

\- StackOverflowError

\- Memory-efficient collection usage



\## Stack



The stack stores method call frames and local variables.



Example:



```java

public void bookTicket() {



&#x20;   int seatNumber = 10;



&#x20;   Passenger passenger =

&#x20;           new Passenger("Mohammed");

}

```



The local references and primitive local variables are associated with the current stack frame.



\## Heap



Objects created using `new` are allocated on the heap.



Example:



```java

Passenger passenger =

&#x20;       new Passenger("Mohammed");

```



The Passenger object is created on the heap.



\## Reference



The variable `passenger` refers to the object.



```text

Stack

&#x20; |

&#x20; | passenger reference

&#x20; v

Heap

&#x20; |

&#x20; | Passenger object

```



\## Garbage Collection



When an object is no longer reachable, it becomes eligible for garbage collection.



Example:



```java

Passenger passenger =

&#x20;       new Passenger("Mohammed");



passenger = null;

```



The original object may become eligible for garbage collection if no other reference points to it.



\## Memory-Aware Design



Avoid:



\- Unnecessary object creation

\- Unbounded collections

\- Keeping unused references

\- Large objects when smaller structures are sufficient

\- Static collections that grow indefinitely



Prefer:



\- Appropriate collection sizes

\- Reusing objects when practical

\- Removing unused entries

\- Returning copies where appropriate

\- Closing external resources



\## Demonstration



The project contains examples showing:



\- Object creation

\- Reference reassignment

\- String pool behavior

\- Garbage collection request

\- Recursion and StackOverflowError demonstration



\## Important Note



`System.gc()` only requests garbage collection. It does not guarantee immediate collection.



\## Expected Outcome



\- Explain stack vs heap.

\- Explain object references.

\- Explain garbage collection.

\- Explain reachability.

\- Identify memory-heavy designs.

\- Understand StackOverflowError and OutOfMemoryError.

\- Write memory-aware Java code.



\## HCL Readiness



\- \[ ] Stack

\- \[ ] Heap

\- \[ ] Reference

\- \[ ] String pool

\- \[ ] Garbage collection

\- \[ ] Reachability

\- \[ ] Object lifetime

\- \[ ] Memory leak concept

\- \[ ] StackOverflowError

\- \[ ] OutOfMemoryError

\- \[ ] Memory-aware collections

\- \[ ] Maven build

\- \[ ] Git branch and merge



\## Git Commit



```text

Day 10: Implement Java memory management examples

```

