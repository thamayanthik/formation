package com.formation.algoblitz.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String... str) {
        int[] a = {4, 3, 2, 1};
        findMinimumAbsoluteDifference(a);
    }

    private static void findMinimumAbsoluteDifference(int[] a) {
        // Sort the array - takes O(nlogn) as it internally uses quick sort
        Arrays.sort(a);

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) { // this for loop takes O(n)
            int currentDiff = Math.abs(a[i] - a[i + 1]);
            minDiff = Math.min(minDiff, currentDiff);
        }

        //brute force approach
        System.out.println("Brute-Force Approach");
        for (int i = 0; i < a.length; i++) { // Brute force approach takes O(n^2)
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) == minDiff) {
                    System.out.print("(" + a[i] + "," + a[j] + ")" + " ");
                }
            }
        }

        System.out.println();
        System.out.println("Single For loop");
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            int currentDiff = Math.abs(a[i] - a[i + 1]);
            if (min == currentDiff) {
                ans.add(List.of(i+1, i + 2));
            } else if (currentDiff < min) {
                ans.clear();
                ans.add(List.of(i+1, i + 2));
            }
            min = currentDiff;
        }

        System.out.print(ans);
    }
}
