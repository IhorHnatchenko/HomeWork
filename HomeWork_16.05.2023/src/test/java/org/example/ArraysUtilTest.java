package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraysUtilTest {

    ArraysUtil arraysUtil = new ArraysUtil();
    private int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
    private int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

    @Test
    void findingCommonElements() {
        List<Integer> list = List.of(1,7);
        Assertions.assertEquals(list, arraysUtil.findingCommonElements(array1,array2));
    }

    @Test
    void findingCommonElementsIf(){
        array1 = new int[]{1, 2, 3};
        array2 = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            arraysUtil.findingCommonElements(array1, array2);
        });
    }
    @Test
    public void testRemoveDuplicates() {
        int[] array = {0, 3, -2, 4, 3, 2};
        Integer[] expected = {0, 3, -2, 4, 2};
        Integer[] result = ArraysUtil.removeDuplicates(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDuplicatesWithNullArray() {
        int[] array = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArraysUtil.removeDuplicates(array);
        });
    }
}