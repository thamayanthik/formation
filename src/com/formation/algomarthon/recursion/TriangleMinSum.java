package com.formation.algomarthon.recursion;

import java.util.*;

public class TriangleMinSum {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.addAll(Collections.singleton(List.of(2)));
        input.addAll(Collections.singleton(List.of(3, 4)));
        input.addAll(Collections.singleton(List.of(6, 5, 7)));
        input.addAll(Collections.singleton(List.of(4, 1, 8, 3)));


        System.out.println(minimumTotal(input, 0, 0));

        System.out.println(minPathSum(input));

    }

    public static int minimumTotal(List<List<Integer>> triangle, int r, int c) {

        if (r == triangle.size()) {
            return 0;
        }

        int minPathSum = triangle.get(r).get(c);
        int leftMin = minimumTotal(triangle, r + 1, c);
        int rightMin = minimumTotal(triangle, r + 1, c + 1);

        minPathSum += Math.min(leftMin, rightMin);

        return minPathSum;

    }

    private static int minPathSum(List<List<Integer>> triangle) {
        int[] memo = new int[triangle.size() + 1];

        for (int r = triangle.size() - 1; r >= 0; r--) {
            for (int c = 0; c < triangle.get(r).size(); c++) {
                memo[c] = triangle.get(r).get(c) + Math.min(memo[c], memo[c + 1]);
            }
        }

        return memo[0];
    }
}

