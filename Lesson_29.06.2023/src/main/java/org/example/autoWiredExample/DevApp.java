package org.example.autoWiredExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DevApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DevConfig.class);

        Position position = context.getBean(Position.class);
        position.printDeveloperInfo();

        PositionCI positionCI = context.getBean(PositionCI.class);
        positionCI.printInfo();

        PositionSI positionSI = context.getBean(PositionSI.class);
        positionSI.printInfo();

    }
}
