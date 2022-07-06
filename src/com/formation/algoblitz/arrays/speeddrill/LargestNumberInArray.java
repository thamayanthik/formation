package com.formation.algoblitz.arrays.speeddrill;

public class LargestNumberInArray {
    public static void main(String[] args) {
        System.out.println("Largest Number : " + largestNumber2ndApproach(new int[]{3, 6, 1, 0}));
        System.out.println("Largest Number : " + largestNumber2ndApproach(new int[]{1, 2, 3, 4}));
        System.out.println("Largest Number : " + largestNumber2ndApproach(new int[]{1}));
    }

    private static int largestNumberFirstApproach(int[] nums) {
        int largest = -1;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int currentLargest = -1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] >= nums[j] * 2) {
                    currentLargest = Math.max(currentLargest, nums[i]);
                } else {
                    currentLargest = -1;
                }
            }

            if (largest < currentLargest) {
                maxIndex  = i;
                largest = currentLargest;
            }
        }

        return maxIndex;
    }

    private static int largestNumber2ndApproach(int[] nums) {
        int largest = -1;
        int maxIndex = -1;

        // find max
        for (int i = 0; i < nums.length; i++) {
            if (largest < nums[i]) {
                maxIndex  = i;
                largest = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (largest != nums[i] && largest < nums[i] * 2) {
                return -1;
            }
        }

        return maxIndex;
    }
}
