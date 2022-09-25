package com.formation.algomarthon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {6, 10}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {6, 10}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 5}}, new int[]{2, 3})));
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 5}}, new int[]{2, 7})));
    }


    public static int[][] insertInterval(int[][] currentIntervals, int[] newInterval) {
        if (currentIntervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<Integer[]> result = new ArrayList<>();

        int currentIndex = 0;
        while (currentIndex < currentIntervals.length) {
            int currentStartRange = currentIntervals[currentIndex][0];
            int currentEndRange = currentIntervals[currentIndex][1];

            if (newInterval[1] < currentStartRange) {
                result.add(new Integer[]{newInterval[0], newInterval[1]});
                int[][] finalResult = new int[result.size() + (currentIntervals.length - currentIndex)][2];
                int row = 0;
                while (row < result.size()) {
                    finalResult[row] = new int[]{result.get(row)[0], result.get(row)[1]};
                    row++;
                }
                System.arraycopy(currentIntervals, currentIndex, finalResult, row, currentIntervals.length - currentIndex);
                return finalResult;
            } else if (newInterval[0] > currentEndRange) {
                result.add(new Integer[]{currentStartRange, currentEndRange});
            } else {
                newInterval = new int[]{Math.min(newInterval[0], currentStartRange), Math.max(newInterval[1], currentEndRange)};
            }
            currentIndex++;
        }

        result.add(new Integer[]{newInterval[0], newInterval[1]});

        if (!result.isEmpty()) {
            int[][] res = new int[result.size()][2];
            int row = 0;
            for (Integer[] r : result) {
                res[row] = new int[]{r[0], r[1]};
                row++;
            }

            return res;
        }

        return new int[][]{{0, 0}};
    }
}
