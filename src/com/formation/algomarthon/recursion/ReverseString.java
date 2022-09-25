package com.formation.algomarthon.recursion;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("Hello", "Hello".length() - 1, ""));
    }

    private static String reverse(String str, int lastIndex, String ans) {
        if (ans.length() == str.length()) {
            return ans;
        }

        ans += str.charAt(lastIndex);

        return reverse(str, --lastIndex, ans);
    }
}
