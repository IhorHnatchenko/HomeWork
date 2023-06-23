package org.example.Exercise3;

import java.util.*;
import java.util.concurrent.*;

public class HippodromeApp {
    public static final int NUM_HORSES = 10;
    public static final int RACE_LENGTH = 100;
    public static Map<Horse, Long> resultMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= NUM_HORSES; i++) {
            executor.submit(new Horse("Horse " + i));
        }

        submit();

        executor.shutdown();

    }


    private static void submit() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<List<String>> futureResult = executorService.submit(new ResultPrinter());

        for (String result : futureResult.get()) {
            System.out.println(result);
        }

        executorService.shutdown();
    }
}
