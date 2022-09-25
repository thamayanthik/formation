package com.algodrill.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetOfString {
    public static void main(String[] args) {

        System.out.println(subSet("AAB"));

        System.out.println("--------------------");

        printSubSetString("", "AAB");
    }

    private static List<String> subSet(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(i + 1);
            generateSubSet(String.valueOf(str.charAt(i)), remaining, result);
        }

        return result;
    }

    private static List<String> generateSubSet(String ans, String remaining, List<String> result) {
        result.add(ans);

        if (remaining.isEmpty()) {
            return result;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String fc = String.valueOf(remaining.charAt(i));
            // If we pass ans + fc, we don't have to undo the changes after recursive call
            generateSubSet(ans + fc, remaining.substring(i + 1), result);
        }

        return result;
    }

    private static void printSubSetString(String ans, String word) {
        if (word.isEmpty()) {
            System.out.print(ans + " ");
            return;
        }

        char chosen = word.charAt(0);
        ans += chosen;
        word = word.substring(1);
        printSubSetString(ans, word); // character chosen
        ans = ans.substring(0, ans.length() - 1);
        printSubSetString(ans, word);
    }
}
