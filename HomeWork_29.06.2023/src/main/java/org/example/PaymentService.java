package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.example.PaymentType.CASH;

@Component
public class PaymentService {



    @Autowired
    private Cash cash;

    @Autowired
    private Card card;

    @Autowired
    private Check check;

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public void pay(PaymentType paymentType) {
        switch (paymentType) {
            case CASH -> cash.pay();
            case CARD -> card.pay();
            case CHECK -> check.pay();
            default -> throw new IllegalArgumentException("Invalid payment type.");
        }
    }
}