package com.hussain.bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BusReservationApp {

    public static void main(String[] args) {

        System.out.println("===== DAY 7 - COLLECTIONS PART 1 =====");

        // LIST
        List<String> routes = new ArrayList<>();

        routes.add("Coimbatore -> Chennai");
        routes.add("Chennai -> Bangalore");
        routes.add("Coimbatore -> Bangalore");

        System.out.println("\nRoutes:");

        for (String route : routes) {
            System.out.println(route);
        }

        // SET
        Set<String> buses = new HashSet<>();

        buses.add("TN01AC1234");
        buses.add("TN01SL5678");
        buses.add("TN01AC1234");

        System.out.println("\nUnique Buses:");

        for (String bus : buses) {
            System.out.println(bus);
        }

        // MAP
        Map<String, String> bookings = new HashMap<>();

        bookings.put("PNR1001", "Mohammed");
        bookings.put("PNR1002", "Rahul");

        System.out.println("\nBookings:");

        for (Map.Entry<String, String> entry
                : bookings.entrySet()) {

            System.out.println(
                    entry.getKey() + " -> "
                            + entry.getValue()
            );
        }

        System.out.println(
                "\nPNR1001 Passenger: "
                        + bookings.get("PNR1001")
        );

        // LINKEDLIST
        LinkedList<String> waitingList =
                new LinkedList<>();

        waitingList.add("Passenger A");
        waitingList.add("Passenger B");

        System.out.println("\nWaiting List:");

        for (String passenger : waitingList) {
            System.out.println(passenger);
        }
    }
}