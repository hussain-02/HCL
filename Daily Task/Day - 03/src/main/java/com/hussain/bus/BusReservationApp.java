package com.hussain.bus;

import java.util.Scanner;

public class BusReservationApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] routes = {
                "Coimbatore -> Chennai",
                "Chennai -> Bangalore",
                "Coimbatore -> Bangalore",
                "Salem -> Chennai"
        };

        boolean[] seats = {
                true,
                false,
                true,
                false,
                true
        };

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("     BUS TICKET RESERVATION SYSTEM");
            System.out.println("========================================");
            System.out.println("1. View Routes");
            System.out.println("2. Search Trips");
            System.out.println("3. View Available Seats");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. View Booking / PNR");
            System.out.println("7. Generate Boarding Manifest");
            System.out.println("8. Revenue Report");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Routes:");

                    for (int i = 0; i < routes.length; i++) {
                        System.out.println((i + 1) + ". " + routes[i]);
                    }
                    break;

                case 2:
                    System.out.println("\nAvailable Routes:");

                    for (String route : routes) {
                        System.out.println(route);
                    }
                    break;

                case 3:
                    System.out.println("\nAvailable Seats:");

                    for (int i = 0; i < seats.length; i++) {

                        if (!seats[i]) {
                            continue;
                        }

                        System.out.println("Seat " + (i + 1));
                    }
                    break;

                case 4:

                    int firstAvailableSeat = -1;

                    for (int i = 0; i < seats.length; i++) {

                        if (seats[i]) {
                            firstAvailableSeat = i + 1;
                            break;
                        }
                    }

                    if (firstAvailableSeat != -1) {
                        System.out.println(
                                "First available seat: "
                                        + firstAvailableSeat
                        );
                    } else {
                        System.out.println("No seats available.");
                    }

                    break;

                case 5:

                    boolean bookingExists = true;

                    if (bookingExists) {
                        System.out.println(
                                "Booking cancelled successfully."
                        );
                    } else {
                        System.out.println("Booking not found.");
                    }

                    break;

                case 6:
                    System.out.println("Displaying booking / PNR...");
                    break;

                case 7:
                    System.out.println("Generating boarding manifest...");
                    break;

                case 8:
                    System.out.println("Generating revenue report...");
                    break;

                case 9:
                    System.out.println(
                            "Thank you for using the system."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please try again."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }
}