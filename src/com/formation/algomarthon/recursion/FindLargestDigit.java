package com.formation.algomarthon.recursion;

public class FindLargestDigit {
    public static void main(String[] args) {
        System.out.println(maxDigit(14263203));
        System.out.println(maxDigit(12));
    }

    private static int maxDigit(int number) {
        if (number == 0) {
            return 0;
        }

        return Math.max(number % 10, maxDigit(number / 10));
    }
}
