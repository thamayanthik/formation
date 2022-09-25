package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationOfString {
    public static void main(String[] args) {
        System.out.println(generateAllPermutation("abc".toCharArray(), "", 0,
                new HashSet<>(), new ArrayList<>()));
    }

    private static List<String> generateAllPermutation(char[] chars, String ans,
                                                       int index, Set<Integer> used, List<String> result) {
        if (index >= chars.length) {
            result.add(ans);
            return result;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                ans += chars[i];
                generateAllPermutation(chars, ans, index + 1, used, result);
                used.remove(i);
                ans = ans.substring(0, ans.length() - 1);
            }
        }

        return result;
    }
}
