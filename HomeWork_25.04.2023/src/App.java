import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scannerForCity = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        List<Trip> tripList = new ArrayList<>();
        tripList.add(new Trip("Tokio", "Warsaw", 14.5, 1400, "18:00", "08:30"));
        tripList.add(new Trip("Tokio", "Berlin", 14.5, 1500, "21:30", "12:00"));
        tripList.add(new Trip("Tokio", "London", 16.0, 1700, "06:00", "22:00"));
        tripList.add(new Trip("Lodz", "London", 6.0, 900, "16:15", "22:15"));
        tripList.add(new Trip("Berlin", "Kiev", 4, 1000, "05:00", "09:00"));
        tripList.add(new Trip("Kiev", "Warsaw", 4, 500, "18:00", "22:00"));
        tripList.add(new Trip("Warsaw", "Lodz", 2, 150, "7:45", "9:45"));
        tripList.add(new Trip("Tokio", "Warsaw", 14.5, 1300, "18:00", "08:30"));
        tripList.add(new Trip("Tokio", "Warsaw", 14.5, 1000, "18:00", "08:30"));

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
                case "Z" -> exit = false;
            }
        }
    }
}