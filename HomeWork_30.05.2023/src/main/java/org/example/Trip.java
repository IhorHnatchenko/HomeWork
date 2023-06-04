package org.example;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDate;

public class Trip {
    private String source;      // Откуда совершается поездка
    private String destination; // Куда совершается поездка
    private double duration;    // Продолжительность полета в часах
    private double price;       // Цена поездки
    private LocalDate startDate;     // Дата вылета
    private LocalDate returnDate;    // Дата возвращения

    public Trip(String source, String destination, double duration, double price, LocalDate startDate, LocalDate returnDate) {
        this.source = source;
        this.destination = destination;
        this.duration = duration;
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

    public double getDuration() {
        return duration;
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

    public String getDepartureCity() {
        return source;
    }



    @Override
    public String toString() {
        return "Trip{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                '}';
    }

    public String getDestinationCity() {
        return destination;
    }
}
