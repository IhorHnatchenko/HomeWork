package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*Условие задачи:
        Создайте класс AnswerCheck с пустым конструктором, который будет выводить какое-нибудь сообщение(пример: Answer
        Check Constructor init), а также создайте метод checkAnswer().
        Создайте класс Exam.java с конструктором, параметром которого является класс AnswerCheck и
        методом examCheck(), который вызывает метод answerCheck().

        Создайте бины из двух вышеупомянутых классов и аннотируйте всё с помощью @Configuration в файле ExamConfig.
        Запустите результаты.*/

        ApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class);

        Exam exam = context.getBean(Exam.class);

        exam.examCheck();

    }
}