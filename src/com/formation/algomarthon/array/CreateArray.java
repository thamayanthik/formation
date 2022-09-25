package com.formation.algomarthon.array;

import java.util.Arrays;

/*
Create an array of integers with a starting number s, an increment value i, and a repetition count r given.

Examples:
Input1: start = 3, increment = 2, repetition count = 5
Output1: [3, 5, 7, 9, 11]
Input2: start = 1, increment = 1, repetition = 3
Output2: [1, 2, 3]
 */
public class CreateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(3, 2, 5)));
    }

    private static int[] createArray(int start, int i, int c) {
        int[] r = new int[c];
        int pos = 0;
        for (int k = 0; k < c; k++) {
            if (k == 0) {
                r[pos] = start;
            } else {
                r[pos] = r[pos - 1] + i;
            }

            pos++;
        }

        return r;
    }
}
