package com.formation.session.algodrill.array.recursion;

public class FindMean {
    public static void main(String[] args) {
        int mean = findMean(new int[]{2, 3, 4, 5, 6}, 0);
        System.out.println("Mean : " + mean);
    }

    private static int findMeanWithTailRecursion(int[] nums, int pos, int sum) {
        if (pos < nums.length) {
            sum += nums[pos];
            return findMeanWithTailRecursion(nums, ++pos, sum);
        } else {
           return sum / nums.length;
        }
    }

    private static int findMean(int[] nums, int pos) {

        if (pos < nums.length) {
            return (nums[pos] + findMean(nums, ++pos)) ;
        }

        return 0;
    }
}
