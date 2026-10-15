package com.hussain.bus;

public class InvalidBookingException
        extends ReservationException {

    public InvalidBookingException(String message) {
        super(message);
    }
}