package com.formation.algomarthon.recursion;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumDigits(11));
        System.out.println(sumDigits(12));
        System.out.println(sumDigits(49));
        System.out.println(sumDigits(9));
        System.out.println(sumDigits(1));
    }

    private static int sumDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return (n % 10) + sumDigits(n / 10);
    }
}
