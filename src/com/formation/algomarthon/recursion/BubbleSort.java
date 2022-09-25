package com.formation.algomarthon.recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {4,5,6,1,2};
        sort(data, 0, true);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] arr, int index, boolean isSorted) {
        if (index >= arr.length - 1) {
            if (isSorted) {
                return;
            }
            isSorted = true;
            index = 0;
        }
        if (arr[index] > arr[index + 1]) {
            int tmp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = tmp;
            isSorted = false;
        }

        sort(arr, index + 1, isSorted);

    }
}
