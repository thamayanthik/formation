package com.formation.algoblitz.hashstructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a list of words, return the most frequent word (the word that occurs the most).
 * You that assume that each word includes only lowercase letters, without punctuations or spaces, and are at least 1 character long.
 * In case of ties for the most frequent word, return the shortest word.
 * Assume that words with the same frequency will always have different lengths.
 * For example:
    * ["man", "cat", "man"] should return "man". The word "man" is most frequent.
    * ["major", "book", "major", "book"] should return "book". Both words have the same frequency, but "book" is shorter.
    * [execution time limit] 3 seconds (java)
 */
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
