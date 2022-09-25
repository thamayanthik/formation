package com.formation.algomarthon.recursion;

/*
Write function that takes 2 inputs n and m and output number of paths from top to bottom right corner of n * m grid
Constraint: you can move right or down just one grid at a time.
Approach:
  Find simpler version of problem
      1 by 1 => 1
      1 by 2 => 1
 */
public class FindPathInGrid {
    public static void main(String[] args) {
        System.out.println(possiblePaths(3, 3));
    }

    private static int possiblePaths(int m, int n) {
        if (n == 1 || m == 1) {
            return 1;
        }

        return possiblePaths(n - 1, m) + possiblePaths(n, m - 1);
    }
}
