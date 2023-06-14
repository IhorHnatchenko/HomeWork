package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class MessageService {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        // Creating BlockingQueue of size = 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue, semaphore);
        Consumer consumer = new Consumer(queue, semaphore);

        // Starting producer to produce message in queue
        new Thread(producer).start();

        // Starting consumer to consume massage from queue
        new Thread(consumer).start();

        System.out.println("Producer and Consumer has been started.");


    }
}
