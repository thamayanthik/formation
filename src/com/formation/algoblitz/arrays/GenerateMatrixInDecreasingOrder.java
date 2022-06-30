package com.formation.algoblitz.arrays;

import java.util.Arrays;

public class GenerateMatrixInDecreasingOrder {
    public static void main(String... str) {
        int[][] decreasingOrderMatrix = generateDecreasingOrder(5);
        System.out.println("Result : " + Arrays.deepToString(decreasingOrderMatrix));
    }

    private static int[][] generateDecreasingOrder(int size) {
        int[][] matrix = new int[size][];

        for (int i = size; i > 0; i--) {
            matrix[size - i] = new int[i];
            for (int j = i; j > 0; j--) {
                matrix[size - i][i - j] = j;
            }
        }

        return matrix;
    }
}
