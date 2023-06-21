package org.example.Exercise3;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HippodromeApp {
    public static final int NUM_HORSES = 10;
    public static final int RACE_LENGTH = 100;
    public static Map<Horse, Long> resultMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();

        for (int i = 1; i <= NUM_HORSES; i++) {
            Horse horse = new Horse("Horse " + i);
            horses.add(horse);
        }

        for (Horse horse : horses) {
            new Thread(horse).start();
        }

        Thread thread = new Thread(new ResultPrinter());
        thread.start();
    }
}
