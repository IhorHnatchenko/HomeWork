package org.example;

import org.springframework.beans.factory.annotation.Autowired;


public class Exam {

    private final AnswerCheck answerCheck;

    @Autowired
    public Exam(AnswerCheck answerCheck) {
        this.answerCheck = answerCheck;
        System.out.println("Exam constructor.");
    }

    public void examCheck(){
        answerCheck.checkAnswer();
    }
}
