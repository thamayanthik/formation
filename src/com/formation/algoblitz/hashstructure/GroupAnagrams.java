package com.formation.algoblitz.hashstructure;

import java.util.*;

/*
Let's define a group of anagrams as a list of words, where each group shares the same anagram.

Anagram means you can rearrange the letters to form any other word in the group (eg: tea could be transformed into eat).

Given a list of words, split it into the smallest possible number of groups of anagrams
and return this number as the answer.

Example

For words = ["tea", "eat", "apple", "ate", "vaja", "cut", "java", "utc"], the output should be 4 (groups).

The 4 groups of anagrams in this example are ("tea", "eat", "ate"), ("apple"), ("vaja", "java"), and ("cut", "utc").

When solving this problem, consider how you tell whether any set of words are anagrams,
and how you might group them together.

For example, "tea" and "eat" share the same anagram - think about how you would figure this out programmatically.

Ultimately, we want to return the number of groups (distinct anagrams, not distinct words) in the input array.

Input/Output

Input: words (array of words)
Output: result (# of groups of anagrams, integer)

[execution time limit] 3 seconds (java)

[input] array.string words

A list of words, each containing only lowercase English letters.

Guaranteed constraints:
1 ? words.length ? 105,
1 ? words[i].length ? 10.

[output] integer

The smallest possible number of groups of anagrams into which words can be split.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = new String[] {"cat", "eat", "ate"};
        System.out.println(groupAnagrams(arr));
    }

    private static int groupAnagrams(String[] words) {
        Map<String, Set<String>> anagrams = new HashMap<>();

        for (int i = 0 ; i <words.length; i++) {
            // Sort the character in the words
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            Set<String> res = anagrams.getOrDefault(sortedStr, new HashSet<>());
            res.add(words[i]);
            anagrams.put(sortedStr, res);

        }
        System.out.println(anagrams.keySet());

        return anagrams.size();
    }
}
