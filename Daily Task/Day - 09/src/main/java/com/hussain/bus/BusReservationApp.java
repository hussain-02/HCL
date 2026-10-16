package com.hussain.bus;

import java.util.List;

public class BusReservationApp {

    public static void main(String[] args) {

        System.out.println("===== DAY 9 - GENERICS =====");

        GenericRepository<Passenger>
                passengerRepository =
                new GenericRepository<>();

        passengerRepository.save(
                new Passenger("Mohammed")
        );

        passengerRepository.save(
                new Passenger("Rahul")
        );

        List<Passenger> passengers =
                passengerRepository.findAll();

        System.out.println("\nPassengers:");

        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }

        GenericRepository<Booking>
                bookingRepository =
                new GenericRepository<>();

        bookingRepository.save(
                new Booking("PNR1001")
        );

        bookingRepository.save(
                new Booking("PNR1002")
        );

        System.out.println("\nBookings:");

        for (Booking booking :
                bookingRepository.findAll()) {

            System.out.println(booking);
        }

        System.out.println(
                "\nPassenger count: "
                        + passengerRepository.size()
        );

        System.out.println(
                "Booking count: "
                        + bookingRepository.size()
        );
    }
}