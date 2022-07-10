package com.formation.algoblitz.recursion;

import java.util.ArrayList;
import java.util.List;

public class FlattenSum {
    public static void main(String[] args) {
        List<Object> input = new ArrayList<>();
        input.add(10);
        input.add(new int[]{1, 1, 1});

        int sum = flattenSumIterative(input);
        System.out.println(sum);
    }

    private static int flattenSumIterative(List<Object> input) {

        int sum = 0;

        for (Object in : input) {
            if (in.getClass().isArray()) {
                int[] data  = (int[]) in;
                for (int a = 0; a<data.length;a++) {
                    sum += data[a];
                }
            } else {
                sum += (int) in;
            }

        }

        return sum;
    }
}
