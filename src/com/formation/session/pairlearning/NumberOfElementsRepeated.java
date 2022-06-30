package com.formation.session.pairlearning;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array and a target count X, return the number of elements that is repeated exactly X times.
 * Function Signature:
 * function numElementsRepeatedX(input, target)
 * Target runtime and space complexity:
 * Runtime: O(n)
 * Space: O(n)
 */
public class NumberOfElementsRepeated {
    public static void main(String... str) {
        int repeatCount = numOfElementRepeatedX(new int[]{1, 2, 3, 1, 2, 3}, 2);
        System.out.println(repeatCount + " repeated 2 times");

        repeatCount = numOfElementRepeatedX(new int[]{1, 2, 3, 1, 2, 3}, 3);
        System.out.println(repeatCount + " repeated 2 times");

        repeatCount = numOfElementRepeatedX(new int[]{1, 3, 3, 5, 5, 5, 5, 5, 3}, 3);
        System.out.println(repeatCount + " repeated 2 times");
    }

    public static int numOfElementRepeatedX(int[] nums, int target) {
        Map<Integer, Integer> numberRepeatCount = new HashMap<>();
        int totalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentCount = numberRepeatCount.getOrDefault(nums[i], 0) + 1;
            if (currentCount == target) {
                totalCount++;
            } else if (totalCount > 0 && currentCount > target) {
                totalCount--;
            }

            numberRepeatCount.put(nums[i], currentCount);
        }
        return totalCount;
    }
}
