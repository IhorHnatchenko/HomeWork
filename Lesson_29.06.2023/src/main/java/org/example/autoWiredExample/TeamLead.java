package org.example.autoWiredExample;

import org.springframework.stereotype.Component;

@Component
public class TeamLead implements Developer{

    @Override
    public void printInfo() {
        System.out.println("I am team lead. ");
    }
}
