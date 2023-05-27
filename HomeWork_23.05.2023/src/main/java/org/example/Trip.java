package org.example;

import java.time.LocalDate;

public class Trip {
    private final String source;      // От куда совершается поездка.
    private final String destination; // До куда совершается поездка.
    private final double hours;       // Количество часов полёта.
    private final double price;       // Цена
    private final LocalDate startDate;     // Время взлёта.
    private final LocalDate returnDate;    // Время посадки.

    public Trip(String source, String destination, double hours, double price, LocalDate startDate, LocalDate returnDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
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

