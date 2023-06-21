package org.example.Exercise3;

import java.util.Date;
import java.util.Map;

public class Horse implements Runnable{

    private String name;
    private double step;
    public Horse(String name){
        this.name = name;
        this.step = Math.random() * 2;
    }

    @Override
    public synchronized void run() {
/*        double result = 0;
        while (result <= HippodromeApp.RACE_LENGTH){
            result += step;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        HippodromeApp.resultMap.put(this, System.currentTimeMillis());*/
        while (HippodromeApp.resultMap.size() < HippodromeApp.NUM_HORSES) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("This thread is interrupted, bye!!");
                break;
            }
        }
        HippodromeApp.resultMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(mapObject -> {
                    long finishTime =mapObject.getValue();
                    // и к выводу времени лучше добавить миллисекунды
                    System.out.println(mapObject.getKey() + " " + new Date(finishTime));
                });
    }

    public double getStep() {
        return step;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", step=" + step +
                '}';
    }
}
