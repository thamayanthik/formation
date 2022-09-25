package com.formation.algomarthon.map;

import java.util.*;

/*
Given a string array chars and an integer k,
return an array of the k most frequent elements in descending order of frequency.

If there is no difference in frequency, we should default to the order in which the elements originally appeared.

eg: ['a', 'b', 'a', 'b', 'b', 'c'], k = 2 => ['b', 'a'].

In this case b has a frequency of 3, so it's first. a has a frequency of 2, so it comes second. And so on.

[execution time limit] 3 seconds (java)

[input] array.char chars

[input] integer k

[output] array.char
 */
public class MostFrequentKElement {
    public static void main(String[] args) {
        char[] res = findMostFrequentKElement(new char[] {'a', 'c', 'b', 'b', 'd', 'a', 'c'}, 2);
        System.out.println(Arrays.toString(res));
    }

    private static char[] findMostFrequentKElement(char[] chars, int k) {
        if (k < chars.length) {
            Map<Character, Integer> cCount = new LinkedHashMap<>();
            for (int i = 0; i < chars.length; i++) {
                cCount.put(chars[i], cCount.getOrDefault(chars[i], 0) + 1);
            }

            List<Character> res = new ArrayList<>();
            cCount.entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .limit(k)
                    .forEach(e -> {
                                res.add(e.getKey());
                            }
                    );

            if (!res.isEmpty()) {
                char[] r = new char[res.size()];
                int i = 0;
                for (Character c : res) {
                    r[i++] = c;
                }

                return r;
            }

            return new char[]{};
        }

        return chars;

    }
}
