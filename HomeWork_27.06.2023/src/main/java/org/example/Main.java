package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student1 = context.getBean("studentIhor", Student.class);
        Student student2 = context.getBean("studentAnna", Student.class);


        System.out.println(student1);
        System.out.println(student2);
    }
}