package com.hussain.bus.model;

public class Passenger extends User {

    private final String phone;

    public Passenger(long id, String name, String phone) {
        super(id, name);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String getRole() {
        return "PASSENGER";
    }
}