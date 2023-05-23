package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraysUtil {
    public List<Integer> findingCommonElements(int[] array1, int[] array2){
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Arrays cannot be null");
        }
        List<Integer> resultOfCommon = new ArrayList<>();
        Arrays.stream(array1).forEach(e -> {
            for (int j : array2) {
                if (e == j) {
                    resultOfCommon.add(j);
                }
            }
        });
        
        return resultOfCommon;
    }

    public static Integer[] removeDuplicates(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        Arrays.stream(array)
                .filter(seen::add)
                .forEach(result::add);

        return result.toArray(new Integer[0]);
    }
}
