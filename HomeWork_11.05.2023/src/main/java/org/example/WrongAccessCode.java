package org.example;

class WrongAccessCode extends Exception {
    public WrongAccessCode(String message) {
        super(message);
    }
}