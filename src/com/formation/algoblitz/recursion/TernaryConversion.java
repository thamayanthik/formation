package com.formation.algoblitz.recursion;

public class TernaryConversion {
    public static void main(String[] args) {
        System.out.println("0 : " + convertToTernaryNumber(0, new StringBuilder()));
        System.out.println("1 : " + convertToTernaryNumber(1, new StringBuilder()));
        System.out.println("2 : " + convertToTernaryNumber(2, new StringBuilder()));
        System.out.println("3 : " + convertToTernaryNumber(3, new StringBuilder()));
        System.out.println("4 : " + convertToTernaryNumber(4, new StringBuilder()));
        System.out.println("92 : " + convertToTernaryNumber(92, new StringBuilder()));
    }

    private static String convertToTernaryNumber(int n, StringBuilder ternary) {
        if (n == 0) {
            return ternary.reverse().toString();
        } else {
            int r = n % 3;
            n = n / 3;
            ternary.append(r);
            return convertToTernaryNumber(n, ternary);
        }
    }
}
