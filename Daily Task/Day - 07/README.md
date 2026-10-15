\# Day 7 — Collections Part 1



\## Objective



Implement Java Collections Framework concepts in the Bus Ticket Reservation System.



\## Topics



\- Collection Framework

\- List

\- ArrayList

\- LinkedList

\- Set

\- HashSet

\- Map

\- HashMap

\- Iteration

\- Choosing the correct collection



\## Project Scenario



The reservation system requires collections for:



\- Routes

\- Buses

\- Bookings

\- PNR lookup



\## Collection Design



| Requirement | Collection | Reason |

|---|---|---|

| Routes | ArrayList | Ordered, duplicates allowed |

| Buses | HashSet | Unique buses |

| Bookings | HashMap | Fast PNR lookup |

| Waiting list | LinkedList | Queue-like operations |



\## Example



```java

List<String> routes = new ArrayList<>();



Set<String> buses = new HashSet<>();



Map<String, String> bookings = new HashMap<>();

```



\## Expected Outcome



\- Select appropriate collection types.

\- Add, remove and search elements.

\- Iterate collections.

\- Explain List vs Set vs Map.

\- Explain ArrayList vs LinkedList.

\- Explain HashSet uniqueness.

\- Explain HashMap key-value storage.



\## HCL Readiness



\- \[ ] List

\- \[ ] Set

\- \[ ] Map

\- \[ ] ArrayList

\- \[ ] LinkedList

\- \[ ] HashSet

\- \[ ] HashMap

\- \[ ] Iterator

\- \[ ] Collection selection

\- \[ ] Maven build

\- \[ ] Git branch and merge



\## Git Commit



```text

Day 7: Implement Java Collections Framework

```

