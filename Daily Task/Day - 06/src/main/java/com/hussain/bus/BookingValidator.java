package com.hussain.bus;

public class BookingValidator {

    public static void validatePassengerName(String name)
            throws InvalidBookingException {

        if (name == null || name.isBlank()) {
            throw new InvalidBookingException(
                    "Passenger name cannot be empty."
            );
        }

        System.out.println("Passenger name is valid.");
    }
}