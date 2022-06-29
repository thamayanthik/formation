package com.formation.algoblitz.arrays;

public class FindAllPairsOfArray {

    public static void main(String... str) {
        printAllPairsOfArray(new int[]{1, 2, 3});
    }

    private static void printAllPairsOfArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                System.out.println("[" + a[i] + "," + a[j] + "]");
            }
        }
    }
}
