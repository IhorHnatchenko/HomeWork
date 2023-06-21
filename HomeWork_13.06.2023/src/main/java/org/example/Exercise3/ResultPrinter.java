package org.example.Exercise3;

import java.util.*;

public class ResultPrinter implements Runnable {

    @Override
    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("This thread is interrupted, bye!!");
                break;
            }
            if(HippodromeApp.resultMap.size() == 3){
                List<Horse> horses = new ArrayList<>(HippodromeApp.resultMap.keySet());
                horses.sort(Comparator.comparingDouble(Horse::getStep));
                horses.forEach(horse -> {
                    long finishTime = HippodromeApp.resultMap.get(horse);
                    System.out.println(horse + " " + new Date(finishTime));
                });
                Thread.currentThread().interrupt();
            }
        }

    }
}
