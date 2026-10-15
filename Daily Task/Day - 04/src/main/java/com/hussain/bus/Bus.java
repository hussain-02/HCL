package com.hussain.bus;

public class Bus {

    private String busNumber;
    private String busType;
    private int totalSeats;
    private int availableSeats;

    public Bus(String busNumber, String busType, int totalSeats) {
        this.busNumber = busNumber;
        this.busType = busType;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeat() {

        if (availableSeats <= 0) {
            return false;
        }

        availableSeats--;
        return true;
    }

    public void cancelSeat() {

        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }
}