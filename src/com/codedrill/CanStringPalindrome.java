package com.codedrill;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string str, return true if it is possible to re-arrange the string into a palindrome, and false if not.
 *
 * eg: cdd => true or cbtre => false
 *
 * Palindrome: "a word, phrase, or sequence that reads the same backward as forward, e.g., madam"
 */
public class CanStringPalindrome {
    public static void main(String[] args) {
        System.out.println(canPalindrome("ma343layalam"));

        System.out.println(canPalindrome("malayalam"));
    }

    private static boolean canPalindrome(String str) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        System.out.println(count);

        long oddCount = count.entrySet().stream().filter(e -> e.getValue() % 2 != 0).count();

        if (oddCount > 1) {
            return false;
        }
        return true;
    }
}
