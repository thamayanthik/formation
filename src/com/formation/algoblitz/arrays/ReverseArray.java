package com.formation.algoblitz.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String... str) {
        int[] a = {1, 2, 3, 4, 5, 6};
        reverse(a);
    }

    /**
     * Reverse the array using two pointer approach
     * @param a
     */
    private static void reverse(int[] a) {
        int left = 0;
        int right = a.length - 1;
        System.out.println("Array Before Reverse : " + Arrays.toString(a));
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        System.out.println("Array After Reverse : " + Arrays.toString(a));
    }
}
