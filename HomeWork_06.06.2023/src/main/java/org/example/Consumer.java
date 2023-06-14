package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;
    private final Semaphore semaphore;

    public Consumer(BlockingQueue<Message> queue, Semaphore semaphore) {
        this.queue = queue;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                Message message = queue.take();
                if (message.equals("exit")) {
                    break;
                }
                System.out.println(message.getMsg());
                Thread.sleep(200);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
