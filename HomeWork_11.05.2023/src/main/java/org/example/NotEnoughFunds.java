package org.example;

class NotEnoughFunds extends Exception {
    public NotEnoughFunds(String message) {
        super(message);
    }
}