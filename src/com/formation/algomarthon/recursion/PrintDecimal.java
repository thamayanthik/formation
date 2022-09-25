package com.formation.algomarthon.recursion;

public class PrintDecimal {
    public static void main(String[] args) {
        printDecimal(1, "");
    }

    private static void printDecimal(int decimal, String ans) {
        if (decimal == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            printDecimal(decimal - 1, ans + i);
        }
    }
}
