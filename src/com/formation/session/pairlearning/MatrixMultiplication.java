package com.formation.session.pairlearning;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixMultiplication(new int[][]{{2, 3}, {4, 5}}, new int[][]{{1, 1}, {1, 1}})));
    }

    private static int[][] matrixMultiplication(int[][] a, int[][] b) {
        if (a.length != b.length) {
            return new int[][]{};
        }

        int[][] res = new int[a.length][a[0].length];
        /**
         * a[r][c] = a[r][c] * b[r][c] + a[r][c+1] * b[r+1][c] etc.,
         */

        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < b.length; c++) {
                int value = 0;
                for (int i = 0; i < a.length; i++) {
                    value += a[r][i] * b[i][c];
                }

                res[r][c] = value;
            }
        }

        return res;
    }
}
