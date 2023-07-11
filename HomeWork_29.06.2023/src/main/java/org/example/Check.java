package org.example;

import org.springframework.stereotype.Component;

// Оплата чеком
@Component
public class Check {
    public void pay() {
        System.out.println("Processing check payment.");
    }
}
