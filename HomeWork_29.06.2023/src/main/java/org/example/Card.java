package org.example;

import org.springframework.stereotype.Component;

@Component
public class Card {
    public void pay() {
        System.out.println("Processing card payment.");
    }
}
