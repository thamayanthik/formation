package com.formation.algomarthon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTraversal {
    public static void main(String[] args) {
        System.out.println("Array With Row Values : " + Arrays.toString(processByRow(new int[][]{{1, 2}, {3, 4}})));
        System.out.println("Array With Row Values(Reverse) : " + Arrays.toString(processByRowReverse(new int[][]{{1, 2}, {3, 4}})));
        System.out.println("Array With Column Values : " + Arrays.toString(processByCol(new int[][]{{1, 2}, {3, 4}})));
        System.out.println("Array With Column Values(Reverse) : " + Arrays.toString(processByColReverse(new int[][]{{1, 2}, {3, 4}})));
        System.out.println("Avg of Minimum Values from Rows : " + smallestAvgOfRows(new int[][]{{32, 23, 3}, {23, 7, 5}}));
        System.out.println("Avg of Minimum Values from Columns : " + smallestAvgOfCols(new int[][]{{32, 23, 3}, {23, 7, 5}}));
    }

    private static Object[] processByRow(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                res.add(arr[r][c]);
            }
        }

        Object[] output = null;
        if (!res.isEmpty()) {
            output = res.toArray();
        }

        return output;
    }

    private static Object[] processByRowReverse(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        for (int r = 0; r < arr.length; r++) {
            for (int c = arr[r].length - 1; c >= 0; c--) {
                res.add(arr[r][c]);
            }
        }

        Object[] output = null;
        if (!res.isEmpty()) {
            output = res.toArray();
        }

        return output;
    }

    private static Object[] processByCol(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        for (int c = 0; c < arr[0].length; c++) {
            for (int r = 0; r < arr.length; r++) {
                res.add(arr[r][c]);
            }
        }

        Object[] output = null;
        if (!res.isEmpty()) {
            output = res.toArray();
        }

        return output;
    }

    private static Object[] processByColReverse(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        for (int c = 0; c < arr[0].length; c++) {
            for (int r = arr.length - 1; r >= 0; r--) {
                res.add(arr[r][c]);
            }
        }

        Object[] output = null;
        if (!res.isEmpty()) {
            output = res.toArray();
        }

        return output;
    }

    private static int smallestAvgOfRows(int[][] arr) {
        int total = 0;

        for (int r = 0; r < arr.length; r++) {
            Integer minValue = Integer.MAX_VALUE;
            for (int c = 0; c < arr[r].length; c++) {
                minValue = Math.min(minValue, arr[r][c]);
            }

            total += minValue;
        }

        return total / arr.length;
    }

    private static int smallestAvgOfCols(int[][] arr) {
        int total = 0;

        for (int c = 0; c < arr[0].length; c++) {
            Integer minValue = Integer.MAX_VALUE;
            for (int r = arr.length - 1; r >= 0; r--) {
                minValue = Math.min(minValue, arr[r][c]);
            }
            total += minValue;
        }

        return total / arr[0].length;
    }
}
