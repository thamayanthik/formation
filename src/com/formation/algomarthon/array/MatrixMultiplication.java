package com.formation.algomarthon.array;

public class MatrixMultiplication {
    public static void main(String[] args) {
        System.out.println(sumOfTwoMatrix(new int[][] {{1,2}, {3,4}}));
    }

    private static int sumOfTwoMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[j][i]);
            }
        }

        return 0;
    }
}
