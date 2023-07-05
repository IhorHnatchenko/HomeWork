package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Message {

    private String message;

    public String getMessage() {
        return message;
    }

    @PostConstruct
    private void init() {
        System.out.println("Hello from init method.");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Hello form destroy method.");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
