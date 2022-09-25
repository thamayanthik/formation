package com.formation.algomarthon.recursion;

public class FilterLettersOnly {
    public static void main(String[] args) {
        System.out.println(filterLetters("Friends, save $$$ with 'Geico'!!", "", 0));
    }

    private static String filterLetters(String str, String ans, int index) {
        if (index >= str.length()) {
            return ans;
        }

        if ((str.charAt(index) >= 'A' && str.charAt(index) <= 'Z')
            || (str.charAt(index) >= 'a' && str.charAt(index) <= 'z')) {
            ans += str.charAt(index);
        }

        return filterLetters(str, ans, index + 1);
    }
}
