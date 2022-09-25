package com.formation.algomarthon.DynamicProgramming;

/*
Given a string, find the longest palindromic substring. You may assume there is only one longest substring.

Examples:

Given a string: "babe" // returns"bab"
Given a string: "aefez" // returns "efe"
[execution time limit] 3 seconds (java)

[input] string string

[output] string

longest palindromic substring
 */

/**
 * Approach:
 *      Case 1: When string has odd length and also no consecutive character same
 *      Case 1: When string has even length and also consecutive character same
 */
public class LongestCommonPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbdd"));

    }

    public static String longestPalindrome(String s) {
        String res = "";
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = right - left + 1;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return res;
    }
}
