package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = {42, 36, 95, 35, 4, 1, 8, 24, 14, 85, 86, 79, 3, 18, 80};
        Calculator calculator = new Calculator();
        System.out.println("Max value is: " + calculator.maxValue(array));
        System.out.println("Min value is: " + calculator.minValue(array));
        int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};
        ArraysUtil arraysUtil = new ArraysUtil();
        List<Integer> integers = arraysUtil.findingCommonElements(array1, array2);
        integers.forEach(print -> System.out.print("| " + print + " |"));

    }
}