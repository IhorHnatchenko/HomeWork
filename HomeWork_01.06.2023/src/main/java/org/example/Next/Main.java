package org.example.Next;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int NUM_USERS = 10;
    private static final int NUM_LISTENER = 4;




    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NUM_USERS; i++) {
            // Создаём 10 потоков, которые являются пользователями, всего их 10
            EventCreator eventCreator = new EventCreator();
            Thread thread = new Thread(eventCreator);

            eventCreator.getEventId().addAndGet(i);

            Thread.sleep(2000);        // Эта штука что бы потоки создавались в правильном порядке.

            thread.start();
        }

        FirewallEventListenerName firewallEventListenerName = new FirewallEventListenerName();
        FirewallEventListenerIp firewallEventListenerIp = new FirewallEventListenerIp();
        FirewallEventListenerData firewallEventListenerData = new FirewallEventListenerData();
        FirewallEventListenerState firewallEventListenerState = new FirewallEventListenerState();

        Thread threadData = new Thread(firewallEventListenerData);
        Thread threadName = new Thread(firewallEventListenerName);
        Thread threadIp = new Thread(firewallEventListenerIp);
        Thread threadState = new Thread(firewallEventListenerState);

        threadName.start();
        threadIp.start();
        threadData.start();
        threadState.start();

    }



}

