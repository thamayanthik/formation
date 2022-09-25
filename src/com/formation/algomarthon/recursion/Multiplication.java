package com.formation.algomarthon.recursion;

public class Multiplication {
    public static void main(String[] args) {
        System.out.println(multiply(5));
        System.out.println(multiplication(5, 2));
        System.out.println(multiplication(5, 1));
        System.out.println(multiplication(5, 5));
    }

    private static int multiply(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        return n * multiply(--n);
    }

    private static int multiplication(int a, int b) {
        if (b == 1) {
            return a;
        }

        return a + multiplication(a, --b);
    }
}
