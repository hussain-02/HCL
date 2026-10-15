package com.hussain.bus;

public class BusReservationApp {

    public static void main(String[] args) {

        BookingService service = new BookingService();

        System.out.println("===== DAY 6 =====");

        try {
            service.bookTicket();

        } catch (ReservationException e) {
            System.out.println(
                    "Booking error: " + e.getMessage()
            );

        } finally {
            System.out.println("Booking operation completed.");
        }

        System.out.println("\n--- Duplicate Booking ---");

        try {
            service.bookTicket();

        } catch (ReservationException e) {
            System.out.println(
                    "Reservation error: " + e.getMessage()
            );
        }

        System.out.println("\n--- Cancellation ---");

        try {
            service.cancelTicket();

        } catch (ReservationException e) {
            System.out.println(
                    "Cancellation error: " + e.getMessage()
            );
        }

        System.out.println("\n--- Invalid Passenger ---");

        try {
            BookingValidator.validatePassengerName("");

        } catch (InvalidBookingException e) {
            System.out.println(
                    "Validation error: " + e.getMessage()
            );
        }

        System.out.println("\nApplication completed safely.");
    }
}