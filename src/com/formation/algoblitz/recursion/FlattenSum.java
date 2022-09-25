package com.formation.algoblitz.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenSum {
    public static void main(String[] args) {
        List<Object> input = new ArrayList<>();
        input.add(10);
        input.add(new int[]{1, 1, 1});

        int sum = flattenSumIterative(input);
        System.out.println(sum);

        System.out.println("-------------------");
        System.out.println("Recursive Result");

        System.out.println(flagSum(input, 0, 0));
    }

    private static int flattenSumIterative(List<Object> input) {

        int sum = 0;

        for (Object in : input) {
            if (in.getClass().isArray()) {
                int[] data = (int[]) in;
                for (int a = 0; a < data.length; a++) {
                    sum += data[a];
                }
            } else {
                sum += (int) in;
            }

        }

        return sum;
    }

    private static int flagSum(List<Object> input, int index, int sum) {
        if (index >= input.size()) {
            return sum;
        }

        Object data = input.get(index);
        if (data.getClass().isArray()) {
            int[] arr = (int[]) data;
            List<Object> list = new ArrayList<>();
            for (int a = 0; a < arr.length; a++) {
                list.add(arr[a]);
            }
            sum += flagSum(list, 0, 0);
        } else {
            sum += (int) data;
        }

        return flagSum(input, ++index, sum);

    }
}
