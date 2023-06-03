package org.example;

public class Horse implements Runnable{

    private String name;
    private double step;
    public Horse(String name){
        this.name = name;
        this.step = Math.random() * 2;
    }

    @Override
    public void run() {
        double result = 0;
        while (result <= HippodromeApp.RACE_LENGTH){
            result += step;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        HippodromeApp.resultMap.put(this, System.currentTimeMillis());
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
