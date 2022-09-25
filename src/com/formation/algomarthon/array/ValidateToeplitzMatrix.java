package com.formation.algomarthon.array;

public class ValidateToeplitzMatrix {
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrixBruteForce(new int[][]{{1, 2}, {3, 1}}));
        System.out.println(isToeplitzMatrixBruteForce(new int[][]{{1, 2}, {3, 4}}));

        System.out.println(isToeplitzMatrix(new int[][]{{1, 2}, {3, 1}}));
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 4}, {1, 1, 5}, {1, 1, 1}}));
    }

    /**
     * InEfficient Solution as it check all the elements rather than just diagonal.
     */
    private static boolean isToeplitzMatrixBruteForce(int[][] arr) {

        for (int r = 0; r < arr.length - 1; r++) {
            for (int c = 0; c < arr[r].length - 1; c++) {
                System.out.println("r1 : " + r + ", c1 : " + c);
                if (arr[r][c] != arr[r + 1][c + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isToeplitzMatrix(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int r = 0; r < rows; r++) {
            System.out.println("+++++++++");
            if (!isValid(arr, r, 0)) {
                return false;
            }
        }

        System.out.println("-----------");
        for (int c = 1; c < cols; c++) {
            if (!isValid(arr, 0, c)) {
                return false;
            }
        }

        return true;
    }

    /*
     r : 0, c : 0
     r : 1, c : 1
     r : 1, c : 0
     r : 0, c : 1
     */

    private static boolean isValid(int[][] arr, int r, int c) {
        int expectedValue = arr[r][c];

        while (r < arr.length && c < arr[0].length) {
            System.out.println("r : " + r + ", c : " + c + ", value : " + arr[r][c] + ", ExpectedValue : " + expectedValue);
            if (arr[r][c] != expectedValue) return false;
            r += 1;
            c += 1;
        }

        return true;
    }

}
