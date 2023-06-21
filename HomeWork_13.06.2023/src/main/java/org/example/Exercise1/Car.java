package org.example.Exercise1;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {

    private String mark;
    private String color;
    private int year;

    private final Semaphore semaphore;

    private final boolean[] freeStations;


    @Override
    public void run() {
        CarGenerator car = new CarGenerator(semaphore, freeStations);

        Car randomCar = car.carGenerator();

        System.out.println(randomCar + " pulled up to a gas station.");
        try {
            semaphore.acquire();


            int tempPull = -1;

            synchronized (freeStations) {
                for (int i = 0; i < freeStations.length; i++) {
                    if (!freeStations[i]) {
                        freeStations[i] = true;
                        System.out.println(randomCar + " is refueled at dispenser by number " + (i + 1));
                        tempPull = i;
                        System.out.println();
                        break;
                    }
                }
            }
            Thread.sleep(500);

            synchronized (freeStations) {
                freeStations[tempPull] = false;
            }
            semaphore.release();

            synchronized (freeStations){
                System.out.println(" <- " + randomCar + " finished their refueled.");
                System.out.println("Gas station with number " + (tempPull + 1) + " is free.");
                System.out.println();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Car(String mark, String color, int year, Semaphore semaphore, boolean[] freeStations) {
        this.mark = mark;
        this.color = color;
        this.year = year;
        this.semaphore = semaphore;
        this.freeStations = freeStations;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
