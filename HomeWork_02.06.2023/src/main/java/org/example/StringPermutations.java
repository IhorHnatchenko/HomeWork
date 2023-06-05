package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutations {
    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutationsHelper("", str, permutations);
        return permutations;
    }

    private static void permutationsHelper(String prefix, String suffix, List<String> permutations) {
        int n = suffix.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutationsHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, n), permutations);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи строку: ");
        String str = scanner.nextLine();

        List<String> result = getPermutations(str);
        for (String permutation : result) {
            System.out.println(permutation);
        }
    }
}
