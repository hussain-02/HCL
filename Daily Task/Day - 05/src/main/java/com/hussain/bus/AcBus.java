package com.hussain.bus;

public class AcBus extends Bus {

    public AcBus(String busNumber, int totalSeats) {
        super(busNumber, totalSeats);
    }

    @Override
    public void displayBusType() {
        System.out.println("AC Bus");
    }
}