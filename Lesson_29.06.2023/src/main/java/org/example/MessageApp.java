package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        Message message = context.getBean(Message.class);

        message.setMessage("Hello");
        System.out.println(message);




    }
}