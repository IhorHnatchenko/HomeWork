package org.example;

import org.springframework.stereotype.Component;

@Component
public class AnswerCheck {

    public AnswerCheck() {
        System.out.println("Answer Check Constructor init");
    }

    public void checkAnswer() {
        System.out.println("Where are checking answer.");
    }
}
