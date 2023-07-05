package org.example.autoWiredExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PositionSI {

    private Developer developer;

    @Autowired
    @Qualifier("seniorJavaDeveloper")
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void printInfo() {
        developer.printInfo();
    }
}
