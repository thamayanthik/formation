package com.formation.algoblitz.arrays;

public class EveryXthValue {
    public static void main(String... str) {
        printEveryXthValue(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }

    private static void printEveryXthValue(int[] a, int n) {
        for (int i = n-1; i < a.length ; i = i + n) {
            System.out.print(a[i] + " ");
        }
    }
}
