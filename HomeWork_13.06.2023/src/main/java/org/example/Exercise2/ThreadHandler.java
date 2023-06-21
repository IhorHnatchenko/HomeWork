package org.example.Exercise2;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ThreadHandler implements Runnable {

    private final int number;
    private final String departure;
    private final String destination;
    private final String[] parcels;
    private final Exchanger<String> exchanger;

    public ThreadHandler(int number, String departure, String destination, String[] parcels, Exchanger<String> exchanger) {
        this.number = number;
        this.departure = departure;
        this.destination = destination;
        this.parcels = parcels;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            System.out.println("In array " + number + " put " + parcels[0] + " and " + parcels[1]);
            System.out.println("Track " + number + " start from " + departure + " to " + destination);

            Thread.sleep(random.nextInt(3) * 1000L);

            parcels[1] = exchanger.exchange(parcels[1]);

            System.out.println("In truck " + number + " put parcel for destination " + destination + ".");
            Thread.sleep(random.nextInt(3) * 1000L);
            System.out.println("----- Truck " + number + " arrived in " + destination + " and delivered " + parcels[0] + " and " + parcels[1] + " ----- ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
