package com.formation.algomarthon.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        /*
            1       2       3       4
            5       6       7       8
            9       10      11      12
            13      14      15      16
         */
        int[][] v = new int[arr.length][arr[0].length];
        //  printSpiralOrder(arr, 0, 0, v);
        //System.out.println(printSpiralOrder1(arr, 0, 0, new ArrayList<>(), arr.length, arr[0].length, v));

        int[][] arr1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        /*
            1       2       3       4
            5       6       7       8
            9       10      11      12
            13      14      15      16
            17      18      19      20
         */
        int[][] v1 = new int[arr1.length][arr1[0].length];
        // System.out.println(printSpiralOrder1(arr1, 0, 0, new ArrayList<>(), arr1.length, arr1[0].length, v1));
        //[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
        int[][] arr2 = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        /*
            1,  2,  3,  4,  5
            6,  7,  8,  9, 10
            11, 12, 13, 14, 15
            16, 17, 18, 19, 20
            21, 22, 23, 24, 25

            [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13]
         */
        int[][] v2 = new int[arr2.length][arr2[0].length];
        System.out.println(generateSpiralOrder(arr2, 0, 0, new ArrayList<>(), arr2.length, arr2[0].length, v2));
    }

    private static void printSpiralOrder(int[][] m, int r, int c, int[][] visited) {
        if (r < 0 || c < 0 || r >= m.length || c >= m[0].length || visited[r][c] == 1) {
            return;
        }

        visited[r][c] = 1;
        System.out.print(m[r][c] + " ");

        printSpiralOrder(m, r, c + 1, visited);
        printSpiralOrder(m, r + 1, c, visited);
        printSpiralOrder(m, r, c - 1, visited);
        printSpiralOrder(m, r - 1, c, visited);
    }

    private static List<Integer> generateSpiralOrder(int[][] m, int r, int c, List<Integer> res, int rl, int cl, int[][] visited) {
        if (r >= rl || c >= cl) {
            return res;
        }

        //System.out.println("r : " + r + ", c : " + c + ", rl : " + rl + ", cl : " + cl);
        int ci = c, ri = r;
        // First row up to col length
        while (c < cl) {
            //System.out.println("Top Row. r : " + r + ", c : " + c + ", = " + m[r][c]);
            if (visited[r][c] != 1) {
                visited[r][c] = 1;
                res.add(m[r][c]);
            }
            c++;
        }
        --c;
        // right column
        while (r < rl) {
           // System.out.println("Right Column. r : " + r + ", c : " + c + ", = " + m[r][c]);
            if (visited[r][c] != 1) {
                visited[r][c] = 1;
                res.add(m[r][c]);
            }
            r++;
        }
        --r;
        // bottom row
        while (c >= ci) {
           // System.out.println("Bottom Row. r : " + r + ", c : " + c + ", = " + m[r][c]);
            if (visited[r][c] != 1) {
                visited[r][c] = 1;
                res.add(m[r][c]);
            }
            c--;
        }

        c++;
        // left column
        while (r >= ri) {
            //System.out.println("Left Column. r : " + r + ", c : " + c + ", = " + m[r][c]);
            if (visited[r][c] != 1) {
                visited[r][c] = 1;
                res.add(m[r][c]);
            }
            r--;
        }

        return generateSpiralOrder(m, ri + 1, ci + 1, res, rl - 1, cl - 1, visited);
    }
}
