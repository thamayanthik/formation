package com.formation.algomarthon.array;

import java.util.Arrays;

/*
Given an array of integers, move all negative numbers to the left in the order they appear.

[execution time limit] 3 seconds (java)

[input] array.integer array

unsorted array

[output] array.integer
 */
public class MoveAllNegativeToLeft {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveNegativeToLeft(new int[]{0, 4, 1, -1, -3, -4})));
    }

    private static int[] moveNegativeToLeft(int[] array) {
        boolean ordered = false;
        while (!ordered) {
            int low = 0;
            ordered = true;
            while (low < array.length - 1) {
                if (array[low] >= 0 && array[low + 1] <= 0) {
                    int tmp = array[low + 1];
                    array[low + 1] = array[low];
                    array[low] = tmp;
                    ordered = false;
                }
                low++;
            }
        }

        return array;
    }
}
