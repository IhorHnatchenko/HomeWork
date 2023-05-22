package org.example;

class IncorrectIbanNumber extends Exception {
    public IncorrectIbanNumber(String message) {
        super(message);
    }
}
