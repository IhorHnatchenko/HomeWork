package org.example.autoWiredExample;

import org.springframework.stereotype.Component;

@Component
public class SeniorJavaDeveloper implements Developer{

    @Override
    public void printInfo() {
        System.out.println("I am senior java developer. ");
    }
}
