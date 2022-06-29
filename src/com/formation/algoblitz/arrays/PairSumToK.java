package com.formation.algoblitz.arrays;

public class PairSumToK {
    public static void main(String... str) {
        int[] a = {1, 5, 8, 10, 13, 18};
        int k = 15;

        System.out.println("Brute Force Pair Exists : " + bruteForceApproach(a, k));
        System.out.println("Two Pointer Pair Exists : " + isPairSumToKExists(a, k));
    }

    private static boolean bruteForceApproach(int[] a, int k) {
        for (int i = 0; i < a.length ; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPairSumToKExists(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int pairSum = a[left] + a[right];
            if (pairSum == k) {
                return true;
            } else if (pairSum > k) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
}
