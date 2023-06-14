package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;
    private final Semaphore semaphore;


    public Producer(BlockingQueue<Message> queue, Semaphore semaphore) {
        this.queue = queue;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        // Produce message
        try {
            semaphore.acquire();

            for (int idx = 0; idx < 50; idx++) {
                Message msg = new Message("-> " + idx, semaphore);
                Thread.sleep(idx * 50);
                queue.put(msg);
                System.out.println("Producer: " + msg.getMsg());
            }
            // Adding exit message
            Message msg = new Message("exit", semaphore);

            queue.put(msg);

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
