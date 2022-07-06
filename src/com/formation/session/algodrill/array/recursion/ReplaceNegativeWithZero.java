package com.formation.session.algodrill.array.recursion;

import java.util.Arrays;

public class ReplaceNegativeWithZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceNegativeWithZero(new int[] {1,2,4,-1, 0, -4}, 0)));
    }

    private static int[] replaceNegativeWithZero(int[] nums, int pos) {
        if (pos >= nums.length) {
            return nums;
        } else if (nums[pos] < 0) {
           nums[pos] = 0;
        }

        return replaceNegativeWithZero(nums, ++pos);
    }
}
