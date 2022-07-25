package com.formation.algoblitz;

public class MatrixAddition {
    public static void main(String[] args) {
        System.out.println(matrixAddition(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    private static int matrixAddition(int[][] array) {
        int sum = 0;
        int len = array.length;

        for (int r = 0; r < array.length; r++) {
            int c = len - r - 1;
            sum += array[r][r];
            if (r != c) {
                sum += array[r][c];
            }
        }

        return sum;
    }
}
