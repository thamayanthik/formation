package com.formation.algoblitz.arrays.speeddrill;

public class BinarySearchClosest {
    public static void main(String[] args) {
        System.out.println("Closet Number : " + findClosestNumber(new int[]{1, 3, 5, 6, 7, 9, 11}, 4));
        System.out.println("Closet Number : " + findClosestNumber(new int[]{1, 2}, 10));
    }

    private static int findClosestNumber(int[] nums, int target) {
        if (target <= nums[0]) {
            return nums[0];
        }

        if (target >= nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return nums[mid];
            }
        }

        System.out.println("high : " + high + ", low : " + low + ", mid : " + mid);

        if (Math.abs(target - nums[mid]) <= Math.abs(nums[mid + 1] - target)) {
            return nums[mid];
        } else {
            return nums[mid + 1];
        }
    }
}
