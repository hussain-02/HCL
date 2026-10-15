package com.hussain.bus;

public class Booking {

    private String pnr;

    public Booking(String pnr) {
        this.pnr = pnr;
    }

    public String getPnr() {
        return pnr;
    }

    @Override
    public String toString() {
        return "Booking{pnr='" + pnr + "'}";
    }
}