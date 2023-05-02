
public class Trip {
    private String source;      // От куда совершается поездка.
    private String destination; // До куда совершается поездка.
    private double hours;       // Количество часов полёта.
    private double price;       // Цена
    private String startDate;     // Время взлёта.
    private String returnDate;    // Время посадки.

    public Trip(String source, String destination, double hours, double price, String startDate, String returnDate) {
        this.source = source;
        this.destination = destination;
        this.hours = hours;
        this.price = price;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", hours=" + hours +
                ", price=" + price +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                "}\n";
    }
}
