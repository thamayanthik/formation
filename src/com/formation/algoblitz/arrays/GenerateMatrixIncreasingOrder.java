package com.formation.algoblitz.arrays;

import java.util.Arrays;

public class GenerateMatrixIncreasingOrder {
    public static void main(String... str) {
        generateMatrix(2);
    }

    private static void generateMatrix(int target) {
        int[][] result = new int[target][];

        //brute force

        for (int i = 0; i < target; i++) {
            result[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                result[i][j] = j + 1;
            }
        }

        System.out.println(Arrays.deepToString(result));


    }
}
