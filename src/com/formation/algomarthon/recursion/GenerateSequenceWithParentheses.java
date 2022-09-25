package com.formation.algomarthon.recursion;

public class GenerateSequenceWithParentheses {

    public static void main(String[] args) {
        System.out.println(generateSequence(1));
        System.out.println(generateSequence(2));
        System.out.println(generateSequence(3));
        System.out.println(generateSequence(4));
        System.out.println(generateSequence(5));
        System.out.println(generateSequence(10));
    }

    private static String generateSequence(int k) {
        if (k <= 0) {
            return "";
        }
        if (k == 1) {
            return "1";
        }

        if (k % 2 == 0) {
            return "(" + k + "+" + generateSequence(k - 1) + ")";
        } else {
            return "(" + generateSequence(k - 1) + "+" + k + ")";
        }
    }
}
