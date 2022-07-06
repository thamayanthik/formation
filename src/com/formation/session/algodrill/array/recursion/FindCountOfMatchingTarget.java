package com.formation.session.algodrill.array.recursion;

public class FindCountOfMatchingTarget {
    public static void main(String[] args) {
        System.out.println(findMatchingCount(new int[] {3,4,5,6,1,5,4,6}, 0, 4, 0));
    }

    private static int findMatchingCount(int[] nums, int pos, int target, int count) {
        if (pos >= nums.length) {
            return count;
        } else if (nums[pos] == target) {
            count++;
        }

        return findMatchingCount(nums, ++pos, target, count);
    }
}
