package com.formation.session.officehours;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 *
 * Let's define a group of anagrams as a list of words, where each group shares the same anagram.
 * Anagram means you can rearrange the letters to form any other word in the group (eg: tea could be transformed into eat).
 * Given a list of words, split it into the smallest possible number of groups of anagrams and return this number as the answer.
 * Example
 * For words = ["tea", "eat", "apple", "ate", "vaja", "cut", "java", "utc"], the output should be 4 (groups).
 * The 4 groups of anagrams in this example are ("tea", "eat", "ate"), ("apple"), ("vaja", "java"), and ("cut", "utc").
 * When solving this problem, consider how you tell whether any set of words are anagrams, and how you might group them together.
 * For example, "tea" and "eat" share the same anagram - think about how you would figure this out programmatically.
 * Ultimately, we want to return the number of groups (distinct anagrams, not distinct words) in the input array.
 */

public class GroupMatchingAnagrams {
    public static void main(String... str) {
        countNumberOfGroupsOfMatchingAnagram(new String[]{"tea", "eat", "apple", "ate", "vaja", "cut", "java", "utc"});
    }

    private static void countNumberOfGroupsOfMatchingAnagram(String[] words) {
        //Sort each words
        //Add sorted words into set
        //Return total elements in the set
        Set<String> sortedWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char tempArray[] = word.toCharArray();
            // Sorting temp array using sort method
            Arrays.sort(tempArray);
            sortedWords.add(new String(tempArray));
        }

        System.out.println("Count : " + sortedWords.size());
    }
}
