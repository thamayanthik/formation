package com.formation.algoblitz.arrays.speeddrill;

import java.util.Arrays;

public class MoveNegativeToLeft {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(usingBubbleSort(new int[] {9, 10, 01, -4, -9, 11})));
        System.out.println(Arrays.toString(simpleLoop(new int[] {9, 10, 01, -4, -9, 11})));
    }

    // It is O(N * M)
    private static int[] usingBubbleSort(int[] arr) {
        boolean ordered = false;
        while (!ordered) {
            int low = 0;
            int next = low + 1;
            ordered = true;
            while (low <= arr.length - 2) {
                if (arr[low] > 0 && arr[low + 1] < 0) {
                    int tmp = arr[next];
                    arr[next] = arr[low];
                    arr[low] = tmp;
                    ordered = false;
                }
                low++;
                next++;
            }
        }
        return arr;
    }

    private static int[] simpleLoop(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }

        return arr;
    }
}
