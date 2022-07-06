package com.formation.session.algodrill.array.recursion;

import java.util.Arrays;

public class ReverseTheArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseTheArray(new int[]{6, 5, 4, 3, 2, 1}, 0)));
    }

    private static int[] reverseTheArray(int[] nums, int pos) {
        if (pos >= nums.length / 2) {
            return nums;
        } else {
            int tmp = nums[pos];
            nums[pos] = nums[nums.length - pos - 1];
            nums[nums.length - pos - 1] = tmp;
            return reverseTheArray(nums, ++pos);
        }
    }
}
