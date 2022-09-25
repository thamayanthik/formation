package com.formation.algomarthon.backtracking;

public class DFSOnArray {
    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {4, 5}, {6, 7}};
        int[][] v = new int[arr.length][arr[0].length];
        dfs(arr, 0, 0, v);
        dfs1(arr, 0, 0, v);
    }

    private static void dfs(int[][] arr, int i, int j, int[][] v) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || v[i][j] == 1) {
            return;
        }

        v[i][j] = 1;
        System.out.print(arr[i][j] + "  ");
        dfs(arr, i, j + 1, v); // move right
        dfs(arr, i + 1, j, v); // move down
        dfs(arr, i - 1, j, v); // move left
        dfs(arr, i, j - 1, v); // move up


    }

    private static void dfs1(int[][] arr, int i, int j, int[][] v) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || v[i][j] == 1) {
            return;
        }

        v[i][j] = 1;
        System.out.print("t " + arr[i][j] + "  ");
        dfs1(arr, i + 1, j, v); // move down
        dfs1(arr, i - 1, j, v); // move up
        dfs1(arr, i, j + 1, v); // move left
        dfs1(arr, i, j - 1, v); // move up


    }
}
