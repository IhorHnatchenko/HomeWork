package org.example;

public class MaxSumWithoutNeighbors {

    public static void main(String[] args) {
        int[] array = {6, 50, 29, 43, 35, 18, 21, 25, 40, 26, 11, 35, 24, 68, 82};

        int maxSum = getMaxSum(array);

        System.out.println("Сумма: " + maxSum);
    }

    public static int getMaxSum(int[] array) {
        int lengthOfArray = array.length;

        if (lengthOfArray <= 2) {
            throw new IllegalArgumentException("Массив  должен сосоять минимум из 2 чисел.");
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < lengthOfArray - 1; i++) {
            for (int j = i + 2; j < lengthOfArray; j++) {
                int sum = array[i] + array[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
