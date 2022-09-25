package com.formation.algomarthon.array;

/*
You have a set of integers s, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the missing number and return it.

Example 1:

Input: nums = [1,2,2,4]
Output: 3
Example 2:

Input: nums = [1,1]
Output: 2

 */
public class FindingMissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{1, 2, 2, 4}));
    }

    private static int findMissing(int[] nums) {
        int missingNumber = 0;
        int lastNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lastNumber + 1 != nums[i]) {
                missingNumber = lastNumber + 1;
                break;
            } else {
                lastNumber = nums[i];
            }
        }
        return missingNumber;
    }
}
