package com.formation.algomarthon.array;

import java.util.Arrays;

public class RearrangeArrayIntoZigZack {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(covertToZigZack(new int[]{4, 3, 7, 8, 6, 2, 1})));
        System.out.println(Arrays.toString(covertToZigZack(new int[]{1, 4, 3, 2})));
    }

    private static int[] covertToZigZack(int[] arr) {
        System.out.println("Input : " + Arrays.toString(arr));
        boolean small = true;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            if (small && arr[i] > arr[i + 1]) {
                swap = true;
            } else if (!small && arr[i] < arr[i + 1]) {
                swap = true;
            }

            small = !small;

            if (swap) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        return arr;
    }
}
