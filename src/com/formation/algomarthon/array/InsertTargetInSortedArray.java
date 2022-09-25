package com.formation.algomarthon.array;

import java.util.Arrays;

/*
Given a sorted array of integers and a target value, insert the target into the array in the appropriate location.
You may assume there are no duplicates.

Example:
Input: array = [1, 2, 4, 5, 6], target = 3
Output: [1, 2, 3, 4, 5, 6]
 */
public class InsertTargetInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertTarget(new int[]{1, 2, 4, 5, 6}, 3)));
    }

    private static int[] insertTarget(int[] array, int target) {
        int[] result = new int[array.length + 1];
        if (array.length == 0) {
            result[0] = target;
        } else if (array.length == 1) {
            if (target < array[0]) {
                result[0] = target;
                result[1] = array[0];
            } else {
                result[0] = array[0];
                result[1] = target;
            }
        } else {
            int idx = 0;
            boolean added = false;

            for (int i = 0; i < array.length; i++) {
                System.out.println("i " + i + ", added : " + added);
                if (!added && (i + 1 < array.length) && array[i] < target && array[i + 1] > target) {
                    result[idx++] = array[i];
                    result[idx++] = target;
                    added = true;
                } else {
                    result[idx++] = array[i];
                }

                System.out.println("i " + i + ", result : " + Arrays.toString(result));

            }

            if (!added) {
                result[idx] = target;
            }
        }

        return result;
    }
}
