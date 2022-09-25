package com.formation.algomarthon.recursion;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam", 0));
    }

    private static boolean isPalindrome(String str, int index) {
        if (index >= str.length() / 2) {
            return true;
        }

        if (Character.toLowerCase(str.charAt(index)) != Character.toLowerCase(str.charAt(str.length() - index - 1))) { // case sensitive
            return false;
        }

        return isPalindrome(str, ++index);
    }
}
