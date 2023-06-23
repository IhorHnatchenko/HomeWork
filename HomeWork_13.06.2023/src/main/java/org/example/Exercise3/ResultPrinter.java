package org.example.Exercise3;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;

public class ResultPrinter implements Callable<List<String>> {
    private String result;
    private final Object monitor = new Object();

    @Override
    public List<String> call() {
        synchronized (monitor) {
            while (HippodromeApp.resultMap.size() < HippodromeApp.NUM_HORSES) {
                try {
                    monitor.wait(1);
                } catch (InterruptedException e) {
                    System.out.println("This thread is interrupted, bye!!");
                    break;
                }

            }
        }

        List<String> results = new ArrayList<>();
        HippodromeApp.resultMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(mapObject -> {
                    long finishTime = mapObject.getValue();
                    // и к выводу времени лучше добавить миллисекунды
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    String formattedTime = dateFormat.format(new Date(finishTime));
                    result = mapObject.getKey() + " " + formattedTime;
                    results.add(result);
                });
        return results;
    }
}
