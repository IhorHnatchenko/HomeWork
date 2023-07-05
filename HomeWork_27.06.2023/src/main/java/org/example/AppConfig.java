package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean
    public Student studentIhor() {
        Student student = new Student();
        student.setName("Ihor");
        student.setAge(21);
        return student;
    }

    @Bean
    public Student studentAnna() {
        Student student = new Student();
        student.setName("Anna");
        student.setAge(20);
        return student;
    }
}
