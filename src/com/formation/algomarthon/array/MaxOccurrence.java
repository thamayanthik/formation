package com.formation.algomarthon.array;

/**
 * Boyer–Moore majority vote algorithm
 * Initialize an element m and a counter i with i = 0
 * For each element x of the input sequence:
 * If i = 0, then assign m = x and i = 1
 * else if m = x, then assign i = i + 1
 * else assign i = i − 1
 * Return m
 */
public class MaxOccurrence {
    public static void main(String[] args) {

        System.out.println(findMaxOccurrence(new int[]{2, 1, 3, 1, 4, 1, 2, 5}));
    }

    private static int findMaxOccurrence(int[] arr) {
        int i = 0;
        int x = 0;
        for (int k = 0; k < arr.length; k++) {
            if (i == 0) {
                x = arr[k];
                i += 1;
            } else if (arr[k] == x) {
                i += 1;
            } else {
                i -= 1;
            }
        }

        int count = 0;
        for (int ij = 0; ij < arr.length; ij++) {
            if (arr[ij] == x) {
                count++;
            }
        }

        if (count > (arr.length / 2)) {
            return x;
        } else {
            return -1;
        }
    }
}
