package com.hussain.bus;

public class BookingService {

    private int availableSeats = 3;
    private boolean bookingActive = false;

    public void bookTicket() {

        if (availableSeats <= 0) {
            throw new SeatNotAvailableException(
                    "No seats available."
            );
        }

        if (bookingActive) {
            throw new InvalidBookingException(
                    "Passenger already has an active booking."
            );
        }

        availableSeats--;
        bookingActive = true;

        System.out.println("Ticket booked successfully.");
        System.out.println("Available seats: " + availableSeats);
    }

    public void cancelTicket() {

        if (!bookingActive) {
            throw new InvalidBookingException(
                    "No active booking found."
            );
        }

        availableSeats++;
        bookingActive = false;

        System.out.println("Ticket cancelled successfully.");
        System.out.println("Available seats: " + availableSeats);
    }
}