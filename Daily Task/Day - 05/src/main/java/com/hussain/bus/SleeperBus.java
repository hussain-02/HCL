package com.hussain.bus;

public class SleeperBus extends Bus {

    public SleeperBus(String busNumber, int totalSeats) {
        super(busNumber, totalSeats);
    }

    @Override
    public void displayBusType() {
        System.out.println("Sleeper Bus");
    }
}