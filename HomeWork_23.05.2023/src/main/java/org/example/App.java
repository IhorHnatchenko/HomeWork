package org.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scannerForCity = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        List<Trip> tripList = new ArrayList<>();
        tripList.add(new Trip("Tokio", "Warsaw", 14.5, 1400,
                LocalDate.of(2023, 1, 27),
                LocalDate.of(2023, 1, 28)));
        tripList.add(new Trip("Tokio", "Berlin", 14.5, 1500,
                LocalDate.of(2023, 2, 7),
                LocalDate.of(2023, 2, 8)));
        tripList.add(new Trip("Tokio", "London", 16.0, 1700,
                LocalDate.of(2023, 4, 22),
                LocalDate.of(2023, 4, 23)));
        tripList.add(new Trip("Lodz", "London", 6.0, 900,
                LocalDate.of(2023, 9, 1),
                LocalDate.of(2023, 9, 1)));
        tripList.add(new Trip("Berlin", "Kiev", 4, 1000,
                LocalDate.of(2023, 12, 6),
                LocalDate.of(2023, 12, 6)));
        tripList.add(new Trip("Kiev", "Warsaw", 4, 500,
                LocalDate.of(2023, 4, 30),
                LocalDate.of(2023, 4, 30)));
        tripList.add(new Trip("Warsaw", "Lodz", 2, 150,
                LocalDate.of(2023, 2, 19),
                LocalDate.of(2023, 2, 19)));
        tripList.add(new Trip("Tokio", "Warsaw", 14.5, 1300,
                LocalDate.of(2023, 10, 26),
                LocalDate.of(2023, 10, 27)));
        tripList.add(new Trip("Tokio", "Warsaw", 14.5, 1000,
                LocalDate.of(2023, 2, 11),
                LocalDate.of(2023, 2, 12)));

        String choice;
        boolean exit = true;
        while (exit) {

            //Я не знал как вам удобнее будтет проверять, но решил всё таки сделать на английском.
            System.out.println("A: Display the entire list of available trips.");
            System.out.println("B: Sort the list in ascending order of price.");
            System.out.println("C: Sort the list in descending order of price.");
            System.out.println("D: Sort by price range.");
            System.out.println("E: Find all available trips from the specified city.");
            System.out.println("F: Sort in a range of cities.");
            System.out.println("G: Output data like: ");
            System.out.println(" * Number of trips.");
            System.out.println(" * Sort all trips by price from lowest to highest.");
            System.out.println(" * For selected points of departure and arrival.");
            System.out.println("H: Filter by date range.");
            System.out.println("If you wont exit pres Z or z.");
            System.out.println();
            System.out.print("Please enter your choice: ");

            choice = scanner.nextLine();
            if (choice.equals(choice.toLowerCase())) {
                choice = choice.toUpperCase();
            }
            switch (choice) {
                case "A" -> {
                    List<Trip> collect = tripList.stream().toList();
                    System.out.println(collect);
                }
                case "B" -> {
                    List<Trip> tripListSortedAscending = tripList.stream()
                            .sorted((x, y) -> {
                                double price1 = x.getPrice();
                                double price2 = y.getPrice();
                                return Double.compare(price1, price2);
                            }).toList();
                    System.out.println(tripListSortedAscending);
                }
                case "C" -> {
                    List<Trip> tripListSortedDescending = tripList.stream()
                            .sorted((x, y) -> {
                                double price1 = x.getPrice();
                                double price2 = y.getPrice();
                                return Double.compare(price2, price1);
                            }).toList();
                    System.out.println(tripListSortedDescending);
                }
                case "D" -> {
                    Scanner scannerInt = new Scanner(System.in);
                    System.out.print("Please enter min price: ");
                    double minPrice = scannerInt.nextInt();
                    System.out.print("Please enter max price: ");
                    double maxPrice = scannerInt.nextInt();
                    List<Trip> tripListSortedInRange = tripList.stream()
                            .filter(x -> x.getPrice() > minPrice && x.getPrice() < maxPrice)
                            .toList();
                    System.out.println(tripListSortedInRange);
                }
                case "E" -> {
                    System.out.print("Please enter start city: ");
                    String startCity = scannerForCity.nextLine();
                    List<Trip> tripListFilterByStartCity = tripList.stream()
                            .filter(x -> startCity.equals(x.getSource()))
                            .toList();
                    System.out.println(tripListFilterByStartCity);
                }
                case "F" -> {
                    System.out.print("Please enter start city: ");
                    String outCity = scannerForCity.nextLine();
                    System.out.print("Please enter destination city: ");
                    String inCity = scannerForCity.nextLine();
                    List<Trip> OutInTripList = tripList.stream()
                            .filter(x -> outCity.equals(x.getSource()) && inCity.equals(x.getDestination()))
                            .toList();
                    System.out.println(OutInTripList);
                }
                case "G" -> {
                    System.out.print("Please enter start city: ");
                    String outCityWithDetails = scannerForCity.nextLine();
                    System.out.print("Please enter destination city: ");
                    String inCityWithDetails = scannerForCity.nextLine();
                    List<Trip> OutInTripListWithDetails = tripList.stream()
                            .filter(x -> outCityWithDetails.equals(x.getSource()) && inCityWithDetails.equals(x.getDestination()))
                            .sorted((x, y) -> {
                                double price1 = x.getPrice();
                                double price2 = y.getPrice();
                                return Double.compare(price1, price2);
                            })
                            .toList();
                    System.out.println("Number of tickets: " + OutInTripListWithDetails.size());
                    System.out.println("Tickets: ");
                    System.out.println(OutInTripListWithDetails);
                }
                case "H" -> {
                    try {
                        Scanner scannerDate = new Scanner(System.in);
                        System.out.print("Please enter the start date (yyyy-MM-dd): ");
                        LocalDate startDate = LocalDate.parse(scannerDate.nextLine());
                        System.out.print("Please enter the radius (in days): ");
                        int radius = scannerDate.nextInt();
                        LocalDate maxDate = startDate.plusDays(radius);
                        List<Trip> tripListFilteredByStartDateAndRadius = tripList.stream()
                                .filter(trip -> trip.getStartDate().compareTo(startDate) >= 0 &&
                                        trip.getStartDate().compareTo(maxDate) <= 0)
                                .toList();
                        System.out.println(tripListFilteredByStartDateAndRadius);
                    } catch (DateTimeException e) {
                        System.out.println("--------------------");
                        System.out.println("Wrong data.");
                        System.out.println("--------------------");
                    }

                }
                case "Z" -> exit = false;
            }
        }
    }
}