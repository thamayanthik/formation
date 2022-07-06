package com.formation.session.algodrill.array.recursion;

public class FindIntegerExists {
    public static void main(String[] args) {
        boolean intExists = findTargetIntegerExistInArray(new int[] {2,3,4,6,7}, 4);
        System.out.println("Result : " + intExists);
        boolean recursiveApproach = isTargetExists(new int[] {2,3,4,6,7}, 0, 10);
        System.out.println("Result : " + recursiveApproach);
    }

    private static boolean findTargetIntegerExistInArray(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }

        return false;
    }

    private static boolean isTargetExists(int[] nums, int pos, int target) {
        if (pos < nums.length && nums[pos] == target) {
            return true;
        } else if (pos > nums.length) {
            return false;
        } else {
           return isTargetExists(nums, ++pos, target);
        }
    }
}
