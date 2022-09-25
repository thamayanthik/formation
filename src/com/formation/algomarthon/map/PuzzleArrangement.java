package com.formation.algomarthon.map;

import java.util.HashSet;
import java.util.Set;

public class PuzzleArrangement {
    public static void main(String[] args) {
        System.out.println(matchingTarget(new int[] {1, 2, 3}, 3));
        System.out.println(matchingTarget(new int[] {1, 1, 1}, 2));
        System.out.println(matchingTarget(new int[] {}, 2));
        System.out.println(matchingTarget(new int[] {1, 1, 1}, 1));
    }

    private static int matchingTarget(int[] arr, int targetSum) {
        int count = 0;
        Set<Integer> processed = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetSum || processed.contains(targetSum - arr[i])) {
                count++;
            }
            processed.add(arr[i]);
        }

        return count;
    }
}
