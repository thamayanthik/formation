package com.formation.algomarthon.recursion;

public class PairStars {
    public static void main(String[] args) {
        printPairStars("hello", 0);
        System.out.println();
        printPairStars("xxyy", 0);
        System.out.println();
        printPairStars("aaaa", 0);
        System.out.println();
        printPairStars("aaab", 0);
        System.out.println();
        printPairStars("aa", 0);
        System.out.println();
        printPairStars("a", 0);
    }

    private static void printPairStars(String ans, int index) {
        if (index >= ans.length()) {
            return;
        }

        System.out.print(ans.charAt(index));

        if (index + 1 < ans.length()) {
            if (ans.charAt(index + 1) == ans.charAt(index)) {
                System.out.print("*");
            }
        }

        printPairStars(ans, index + 1);
    }
}
