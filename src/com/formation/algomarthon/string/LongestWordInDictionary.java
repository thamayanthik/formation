package com.formation.algomarthon.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        System.out.println(findLongestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }

    private static String findLongestWord(String[] words) {
        Arrays.sort(words);
        String res = "";

        Set<String> p = new HashSet<>();

        for (String word : words) {
            if (word.length() == 1 || p.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > res.length()) {
                    res = word;
                }
                p.add(word);
            }
        }

        return res;
    }
}
