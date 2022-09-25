package com.formation.algomarthon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagMatrixTraversal {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}};

        System.out.println(Arrays.toString(convertMatrixToArray(arr)));
    }

    private static Object[] convertMatrixToArray(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    result.add(arr[i][j]);
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    result.add(arr[i][j]);
                }
            }

        }

        Object[] res = null;
        if (!result.isEmpty()) {
            res = result.toArray();
        }

        return res;
    }
}
