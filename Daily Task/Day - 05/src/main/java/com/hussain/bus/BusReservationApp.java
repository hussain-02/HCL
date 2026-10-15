package com.hussain.bus;

public class BusReservationApp {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   BUS RESERVATION SYSTEM - DAY 5");
        System.out.println("==================================");

        AcBus acBus = new AcBus("TN01AC1234", 40);
        SleeperBus sleeperBus = new SleeperBus("TN01SL5678", 30);

        System.out.println("\n--- AC BUS ---");
        acBus.displayDetails();
        acBus.displayBusType();

        System.out.println("\n--- SLEEPER BUS ---");
        sleeperBus.displayDetails();
        sleeperBus.displayBusType();

        System.out.println("\n--- RUNTIME POLYMORPHISM ---");

        Bus bus;

        bus = new AcBus("TN02AC1111", 40);
        bus.displayBusType();

        bus = new SleeperBus("TN02SL2222", 30);
        bus.displayBusType();
    }
}