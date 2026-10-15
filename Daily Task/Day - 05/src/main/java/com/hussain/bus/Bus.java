package com.hussain.bus;

public class Bus {

    protected String busNumber;
    protected int totalSeats;

    public Bus(String busNumber, int totalSeats) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
    }

    public void displayBusType() {
        System.out.println("Normal Bus");
    }

    public void displayDetails() {
        System.out.println("Bus Number: " + busNumber);
        System.out.println("Total Seats: " + totalSeats);
    }
}