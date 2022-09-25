package com.formation.algomarthon.backtracking;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LetterTilePossibilities {
    // private static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        int count = findAllCombinationCount(convertCharCount("AAB"), "", new HashSet<>());
        System.out.println("AAB : " + count);
        count = findAllCombinationCount(convertCharCount("AAABBC"), "", new HashSet<>());
        System.out.println("AAABBC : " + count);
        count = findAllCombinationCount(convertCharCount("WIG"), "", new HashSet<>());
        System.out.println("WGI : " + count);
    }

    private static int findAllCombinationCount(Map<Character, Integer> counter, String ans, Set<String> result) {
        if (counter.size() == 0) {
            return 0;
        }

        Iterator<Map.Entry<Character, Integer>> itr = counter.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, Integer> count = itr.next();
            if (count.getValue() > 0) {
                ans += count.getKey();
                result.add(ans);
                counter.put(count.getKey(), counter.get(count.getKey()) - 1);
                findAllCombinationCount(createCopy(counter), ans, result);
                counter.put(count.getKey(), counter.getOrDefault(count.getKey(), 0) + 1);
                ans = ans.substring(0, ans.length() - 1);
            }
        }

        //System.out.println(result);
        return result.size();
    }

    private static Map<Character, Integer> convertCharCount(String str) {
        Map<Character, Integer> charCount = new ConcurrentHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    private static Map<Character, Integer> createCopy(Map<Character, Integer> map) {
        Map<Character, Integer> charCount = new ConcurrentHashMap<>();
        map.forEach((key, value) -> {
            charCount.put(key, value);
        });

        return charCount;
    }


}

