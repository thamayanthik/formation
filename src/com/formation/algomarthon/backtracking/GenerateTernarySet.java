package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateTernarySet {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }

    private static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        if (n > 1) {
            startIndex = 1;
        }
        for (int i = startIndex; i < 3; i++) {
             generateTernary(n, String.valueOf(i), result);
        }

        return result;
    }

    private static List<String> generateTernary(int n, String ans, List<String> result) {
        if (ans.length() == n) {
            result.add(ans);
            return result;
        }

        for (int j = 0; j < 3; j++) {
           // ans += String.valueOf(j); - > include / choose
            generateTernary(n, ans + j, result);
           // ans = ans.substring(0, ans.length() - 1); -> exclude/un choose
        }

        return result;
    }
}
