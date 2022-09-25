package com.formation.algomarthon.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZero {
    public static void main(String[] args) {
        setZeroesExtraSpace(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        System.out.println("--------------------------------------");
        setZeroesExtraSpace(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

    public static void setZeroesExtraSpace(int[][] matrix) {
        // Find the rows and column to be changed to zero
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void setZeroesInPlace(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    fillZero(matrix, i, j);
                }
            }
        }
    }

    public static void fillZero(int[][] m, int row, int col) {
        int c = 0;
        while (c < m[row].length) {
            if (m[row][c] != 0) {
                m[row][c] = 0;
            }
            c++;
        }

        int r = 0;
        while (r < m.length) {
            if (m[r][col] != 0) {
                m[r][col] = 0;
            }
            r++;
        }
    }
}
