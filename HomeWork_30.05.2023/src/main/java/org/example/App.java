package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String LOG_FILE = "C:\\Users\\RexBeer\\Documents\\Tel-ran\\git\\TelRan\\HomeWork_30.05.2023\\log.txt";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static PrintWriter writer;

    public static void main(String[] args) {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            System.out.println("Failed to initialize logger: " + e.getMessage());
            writer.println("Failed to initialize logger: " + e.getMessage());
            writer.flush();
        }

        Scanner scannerForCity = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        List<Trip> tripList = createTripList();

        String choice;
        boolean exit = true;
        while (exit) {
            writer.println("A: Display the entire list of available trips.");
            writer.println("B: Sort the list in ascending order of price.");
            writer.println("C: Sort the list in descending order of price.");
            writer.println("D: Sort by price range.");
            writer.println("E: Find all available trips from the specified city.");
            writer.println("F: Sort in a range of cities.");
            writer.println("G: Output data like:");
            writer.println(" * Number of trips.");
            writer.println(" * Sort all trips by price from lowest to highest.");
            writer.println(" * For selected points of departure and arrival.");
            writer.println("H: Filter by date range.");
            writer.println("If you want to exit, press Z or z.");
            writer.println();
            writer.print("Please enter your choice: ");
            writer.flush();

            choice = scanner.nextLine();
            if (choice.equals(choice.toLowerCase())) {
                choice = choice.toUpperCase();
            }

            writer.println("User choice: " + choice);
            writer.flush();

            switch (choice) {
                case "A":
                    displayAllTrips(tripList);
                    break;
                case "B":
                    sortTripsAscendingByPrice(tripList);
                    break;
                case "C":
                    sortTripsDescendingByPrice(tripList);
                    break;
                case "D":
                    sortTripsByPriceRange(tripList);
                    break;
                case "E":
                    findTripsFromCity(tripList, scannerForCity);
                    break;
                case "F":
                    sortTripsByCityRange(tripList, scannerForCity);
                    break;
                case "G":
                    outputTripDetails(tripList, scannerForCity);
                    break;
                case "H":
                    filterTripsByDateRange(tripList, scanner);
                    break;
                case "Z":
                    exit = false;
                    break;
                default:
                    writer.println("Invalid choice. Please try again.");
                    writer.flush();
                    break;
            }
        }

        writer.close();
    }

    private static void log(String message) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true));
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
            writer.println(timestamp + " - " + message);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to log message: " + e.getMessage());
        }
    }


    private static List<Trip> createTripList() {
        List<Trip> tripList = List.of(
                new Trip("Tokio", "Warsaw", 14.5, 1400,
                        LocalDate.of(2023, 1, 27),
                        LocalDate.of(2023, 1, 28)),
                new Trip("Tokio", "Berlin", 14.5, 1500,
                        LocalDate.of(2023, 2, 20),
                        LocalDate.of(2023, 2, 25)),
                new Trip("Warsaw", "Berlin", 5.0, 200,
                        LocalDate.of(2023, 3, 10),
                        LocalDate.of(2023, 3, 12)),
                new Trip("Berlin", "Tokio", 18.5, 1600,
                        LocalDate.of(2023, 4, 5),
                        LocalDate.of(2023, 4, 10)),
                new Trip("Warsaw", "Tokio", 15.0, 1700,
                        LocalDate.of(2023, 5, 15),
                        LocalDate.of(2023, 5, 20))
        );

        return tripList;
    }

    private static void displayAllTrips(List<Trip> tripList) {
        writer.println("List of available trips:");
        for (Trip trip : tripList) {
            writer.println(trip);
        }
        writer.println();
        writer.flush();
        log("Display all trips.");
    }

    private static void sortTripsAscendingByPrice(List<Trip> tripList) {
        List<Trip> mutableList = new ArrayList<>(tripList);
        mutableList.sort(Comparator.comparingDouble(Trip::getPrice));
        writer.println("List of trips sorted in ascending order of price:");
        for (Trip trip : mutableList) {
            writer.println(trip);
        }
        writer.println();
        writer.flush();
        log("Sorted trips in ascending order of price");
    }

    private static void sortTripsDescendingByPrice(List<Trip> tripList) {
        List<Trip> mutableList = new ArrayList<>(tripList);
        mutableList.sort((t1, t2) -> Double.compare(t2.getPrice(), t1.getPrice()));
        writer.println("List of trips sorted in descending order of price:");
        for (Trip trip : mutableList) {
            writer.println(trip);
        }
        writer.println();
        writer.flush();
        log("Sorted trips in descending order of price");
    }

    private static void sortTripsByPriceRange(List<Trip> tripList) {
        Scanner scanner = new Scanner(System.in);
        writer.println("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        writer.println("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        writer.println("List of trips within the price range of " + minPrice + " - " + maxPrice + ":");
        for (Trip trip : tripList) {
            if (trip.getPrice() >= minPrice && trip.getPrice() <= maxPrice) {
                writer.println(trip);
            }
        }
        writer.println();
        writer.flush();
        log("Filtered trips by price range (" + minPrice + " - " + maxPrice + ")");
    }

    private static void findTripsFromCity(List<Trip> tripList, Scanner scanner) {
        writer.println("Enter the city to find trips from: ");
        String city = scanner.nextLine();

        writer.println("List of trips from " + city + ":");
        for (Trip trip : tripList) {
            if (trip.getDepartureCity().equalsIgnoreCase(city)) {
                writer.println(trip);
            }
        }
        writer.println();
        writer.flush();
        log("Found trips from " + city);
    }

    private static void sortTripsByCityRange(List<Trip> tripList, Scanner scanner) {
        writer.println("Enter the starting city: ");
        String startCity = scanner.nextLine();
        writer.println("Enter the ending city: ");
        String endCity = scanner.nextLine();

        writer.println("List of trips between " + startCity + " and " + endCity + ":");
        for (Trip trip : tripList) {
            if (trip.getDepartureCity().equalsIgnoreCase(startCity) &&
                    trip.getDestinationCity().equalsIgnoreCase(endCity)) {
                writer.println(trip);
            }
        }
        writer.println();
        writer.flush();
        log("Sorted trips by city range (" + startCity + " - " + endCity + ")");
    }

    private static void outputTripDetails(List<Trip> tripList, Scanner scanner) {
        writer.println("Number of trips: " + tripList.size());
        sortTripsAscendingByPrice(tripList);

        writer.println("Enter the departure city: ");
        String departureCity = scanner.nextLine();
        writer.println("Enter the arrival city: ");
        String arrivalCity = scanner.nextLine();

        writer.println("List of trips from " + departureCity + " to " + arrivalCity + ":");
        for (Trip trip : tripList) {
            if (trip.getDepartureCity().equalsIgnoreCase(departureCity) &&
                    trip.getDestinationCity().equalsIgnoreCase(arrivalCity)) {
                writer.println(trip);
            }
        }
        writer.println();
        writer.flush();
        log("Output trip details for " + departureCity + " to " + arrivalCity);
    }


    private static void filterTripsByDateRange(List<Trip> tripList, Scanner scanner) {
        writer.println("Enter the start date (yyyy-MM-dd): ");
        String startDateString = scanner.nextLine();
        writer.println("Enter the end date (yyyy-MM-dd): ");
        String endDateString = scanner.nextLine();

        LocalDate startDate = LocalDate.parse(startDateString);
        LocalDate endDate = LocalDate.parse(endDateString);

        writer.println("List of trips within the date range of " + startDate + " - " + endDate + ":");
        for (Trip trip : tripList) {
            if (trip.getStartDate().isAfter(startDate) && trip.getReturnDate().isBefore(endDate)) {
                writer.println(trip);
            }
        }
        writer.println();
        writer.flush();
        log("Filtered trips by date range (" + startDate + " - " + endDate + ")");
    }
}
