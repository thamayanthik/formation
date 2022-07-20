package com.formation.algoblitz.recursion;

public class FindFibonacci {
    public static void main(String[] args) {
        System.out.println(findFibonacci(3));
    }

    private static int findFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return findFibonacci(n - 1) + findFibonacci(n - 2);
        }
    }
}
