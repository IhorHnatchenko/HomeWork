package org.example;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();
    private final int[] array = {42, 36, 95, 35, 4, 1, 8, 24, 14, 85, 86, 79, 3, 18, 80};


    @org.junit.jupiter.api.Test
    void maxValue() {
        Assertions.assertEquals(95, calculator.maxValue(array));
    }

    @org.junit.jupiter.api.Test
    void minValue() {
        Assertions.assertEquals(1, calculator.minValue(array));
    }
}