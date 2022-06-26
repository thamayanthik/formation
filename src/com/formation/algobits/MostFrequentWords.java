package com.formation.algobits;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentWords {
    public static void main(String... str) {
        String[] words = {"man", "word", "man"};

        Map<String, Integer> wordCount = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i =0; i < words.length; i++) {
            int currentCount = 1;
            if (wordCount.containsKey(words[i])) {
                currentCount += wordCount.get(words[i]);
            }

            wordCount.put(words[i], currentCount);

            maxCount = Math.max(maxCount, currentCount);
        }

        int finalMaxCount = maxCount;
        List<String> values = wordCount.keySet().stream().sorted().filter(key -> wordCount.get(key) == finalMaxCount).collect(Collectors.toList());
        int wordLen = Integer.MAX_VALUE;
        String word = "";
        for (String value :  values) {
            if (wordLen > value.length()) {
                word = value;
            }
            wordLen = Math.min(wordLen, value.length());
        }

        System.out.println(word);
    }
}
