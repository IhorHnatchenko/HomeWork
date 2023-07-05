package org.example.autoWiredExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Position {

    @Autowired
    private Developer javaDeveloper;

    @Autowired
    private Developer seniorJavaDeveloper;

    public void printDeveloperInfo(){
        javaDeveloper.printInfo();
        seniorJavaDeveloper.printInfo();
    }
}
