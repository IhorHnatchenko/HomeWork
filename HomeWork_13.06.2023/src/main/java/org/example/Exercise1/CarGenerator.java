package org.example.Exercise1;

import org.example.Exercise1.Car;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarGenerator {

    private static final String[] MARKS = {"Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Mercedes-Benz"};
    private static final String[] COLORS = {"Red", "Blue", "Green", "White", "Black", "Silver"};
    private static final int MIN_YEAR = 2000;
    private static final int MAX_YEAR = 2023;

    private final Semaphore semaphore;

    private final boolean[] freeStations;

    public CarGenerator(Semaphore semaphore, boolean[] freeStations) {
        this.semaphore = semaphore;
        this.freeStations = freeStations;
    }

    public Car carGenerator() {
        Random random = new Random();

        String mark = MARKS[random.nextInt(MARKS.length)];
        String color = COLORS[random.nextInt(COLORS.length)];
        int year = random.nextInt(MAX_YEAR - MIN_YEAR + 1) + MIN_YEAR;

        return new Car(mark, color, year, semaphore, freeStations);
    }


}
