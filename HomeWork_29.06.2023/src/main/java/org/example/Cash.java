package org.example;

import org.springframework.stereotype.Component;

@Component
public class Cash {
    public void pay() {
        System.out.println("Processing cash payment.");
    }
}
