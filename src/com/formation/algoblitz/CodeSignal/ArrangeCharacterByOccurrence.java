package com.formation.algoblitz.CodeSignal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given any string str, sort the characters in descending order based on the number of occurrences of each character in the string str.
 * Return an array of the characters in order. You may assume each character has a distinct/non-overlapping frequency.
 * eg: "gggghlee" => ["g", "e", "h", "l"]
 * [execution time limit] 3 seconds (java)
 * [input] string str
 * [output] array.char
 * [Java] Syntax Tips
 */
public class ArrangeCharacterByOccurrence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCharacterByOccurrence("ggggghlee")));

        System.out.println(Arrays.toString(getCharacterByOccurrence("")));
    }

    private static Object[] getCharacterByOccurrence(String s) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        Object[] chars = charCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(e -> e.getKey())
               .toArray();

        return chars;
    }
}
