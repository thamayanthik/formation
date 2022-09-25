package com.formation.algomarthon.backtracking;

public class PrintBinary {
    public static void main(String[] args) {
        printBinaryWithSingleForLoop(3, "");
        System.out.println("----------------");
        printBinary(3, "");
    }

    private static void printBinaryWithSingleForLoop(int n, String ans) {
        if (ans.length() == n) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            ans += i;
            printBinaryWithSingleForLoop(n, ans);
            ans = ans.substring(0, ans.length() - 1);
        }
    }

    private static void printBinary(int n, String ans) {
        /**
         * printBinary(2, "0")
         *       printBinary(1, "00")
         *          printBinary(0, "000")
         *          printBinary(0, "001")
         *       printBinary(1, "01")
         *          printBinary(0, "010")
         *          printBinary(0, "011")
         * printBinary(2, "1")
         *       printBinary(1, "10")
         *          printBinary(0, "100")
         *          printBinary(0, "101")
         *       printBinary(1, "11")
         *          printBinary(0, "110")
         *          printBinary(0, "111")
         */
        if (n == 0) {
            System.out.println(ans);
            return;
        }

        printBinary(n - 1, ans + "0");
        printBinary(n - 1, ans + "1");
    }
}
