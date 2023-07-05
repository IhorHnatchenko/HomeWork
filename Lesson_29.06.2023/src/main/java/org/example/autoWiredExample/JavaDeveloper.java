package org.example.autoWiredExample;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class JavaDeveloper implements Developer{

    @Override
    public void printInfo() {
        System.out.println("I am Java dev.");
    }

}
