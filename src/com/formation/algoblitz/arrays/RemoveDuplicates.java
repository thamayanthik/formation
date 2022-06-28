package com.formation.algoblitz.arrays;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String... str) {
        String[] values = {"oliver", "pixel", "oliver", "pinky"};
        solution1(values);
        String[] values1 = {"oliver", "pixel", "oliver", "pinky"};
        solution2(values1);
    }

    private static void solution1(String[] values) {
        Set<String> duplicate = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            if (duplicate.contains(values[i])) {
                values[i] = "";
            }
            duplicate.add(values[i]);
        }

        System.out.println(Arrays.toString(values));
    }

    private static void solution2(String[] values) {
        Set<String> duplicate = new HashSet<>();
        List<String> output = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (duplicate.contains(values[i])) {
                values[i] = "";
            } else {
                output.add(values[i]);
            }
            duplicate.add(values[i]);
        }

        System.out.println(output);
    }
}
