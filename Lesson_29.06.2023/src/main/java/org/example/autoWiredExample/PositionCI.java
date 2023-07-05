package org.example.autoWiredExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PositionCI {

    private final Developer developer;

    @Autowired
    public PositionCI(@Qualifier("seniorJavaDeveloper") Developer developer) {
        this.developer = developer;
    }

    public void printInfo() {
        developer.printInfo();
    }
}
