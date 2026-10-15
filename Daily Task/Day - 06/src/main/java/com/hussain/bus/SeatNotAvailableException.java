package com.hussain.bus;

public class SeatNotAvailableException
        extends ReservationException {

    public SeatNotAvailableException(String message) {
        super(message);
    }
}