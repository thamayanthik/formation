package com.formation.algomarthon.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/*

Given an array of integers, reverse the array by blocks of k.

Examples:

Input: array = [1,2,3,4,5,6], k = 3
Output: [3,2,1,6,5,4]  // Since k is 3, divide the array by a block of 3 elements: [1, 2, 3] and [4,5,6] and reverse it by blocks.

If k doesn't evenly divide, accept and reverse the last block after reversing all of the others.
Input: array = [1,2,3,4,5], k = 3
Output: [3,2,1,5,4] // [1,2,3] and [4,5]

If k exceeds the length of the array, do nothing.
Input: array = [1,2], k = 3
Output: [1,2]
 */
public class ReverseArrayByKBlock {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(reverse(new int[]{1, 2}, 3)));
    }

    private static int[] reverse(int[] array, int k) {
        if (array.length >= k) {
            for (int i = 0; i < array.length; i = i + k) {
                int low = i;
                int high = low + k - 1;
                if (high >= array.length) {
                    high = array.length - 1;
                }
                while (low <= high) {
                    int tmp = array[low];
                    array[low] = array[high];
                    array[high] = tmp;
                    low++;
                    high--;
                }
            }
        }


        return array;
    }
}
