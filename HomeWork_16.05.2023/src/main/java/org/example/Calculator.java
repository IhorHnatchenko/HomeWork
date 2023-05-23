package org.example;

import java.util.Arrays;

public class Calculator {
    public Integer maxValue(int[] array){
        return Arrays.stream(array).max().getAsInt();
    }

    public Integer minValue(int[] array){
        return Arrays.stream(array).min().getAsInt();
    }
}
