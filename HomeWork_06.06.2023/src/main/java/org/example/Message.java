package org.example;

import java.util.concurrent.Semaphore;

public class Message {
    private final String msg;
    private final Semaphore semaphore;


    public Message(String msg, Semaphore semaphore) {
        this.msg = msg;
        this.semaphore = semaphore;
    }

    public String getMsg() {
        return msg;
    }
}
