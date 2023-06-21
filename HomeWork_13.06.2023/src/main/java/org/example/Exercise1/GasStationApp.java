package org.example.Exercise1;

import org.example.Exercise1.CarGenerator;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class GasStationApp {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4, true);

        boolean[]freeStations = new boolean[4];

        CarGenerator car = new CarGenerator(semaphore, freeStations);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime futureTime = now.plusSeconds(10);

        while (true){
            Thread carThread = new Thread(car.carGenerator());
            carThread.start();
            Thread.sleep(1000);
            if(LocalDateTime.now().isAfter(futureTime)){
                System.out.println("End.///////////////////////////////////////////////////////////////");
                break;
            }
        }
    }
}