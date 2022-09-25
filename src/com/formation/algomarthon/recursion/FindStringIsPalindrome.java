package com.formation.algomarthon.recursion;

public class FindStringIsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abbaa"));
    }

    private static boolean isPalindrome(String str) {
        if (str.length() < 2) {
            return true;
        }

        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first == last) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }
}
