package com.formation.algomarthon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GuessWord {
    Map<Integer, Set<Character>> unmatchedIndex = new HashMap<>();
    Map<Integer, Character> matchingChars = new HashMap<>();
    String mostCharMatchWord = "";
    boolean process = false;
    public void findSecretWord(String[] words) { // Master master) {
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < words.length;i++) {
            wordSet.add(words[i]);
        }

        while (true && !wordSet.isEmpty()) {
            String guessedWord = wordSet.stream().findAny().get();

            wordSet.remove(guessedWord);
            int matchCount = 6; //master.guess(guessedWord);

            if (matchCount == 6) {
                return;
            }

            if (matchCount == 5 && !process && mostCharMatchWord.isEmpty()) {
                mostCharMatchWord = guessedWord;
                process = true;
            } else if (matchCount == 5 && process && !mostCharMatchWord.isEmpty()) {
                for (int i = 0; i < 6; i++) {
                    if (mostCharMatchWord.charAt(i) == guessedWord.charAt(i)) {
                        matchingChars.put(i, mostCharMatchWord.charAt(i));
                    }
                }
                removeNotMatchingWord(wordSet);
                mostCharMatchWord = "";
            }

            if (matchCount > 0) {
                cleanNotMatching(wordSet, guessedWord, matchCount);
            } else {
                char[] chars = guessedWord.toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    char gw = chars[k];
                    Set<Character> currentChars = unmatchedIndex.getOrDefault(k, new HashSet<>());
                    currentChars.add(gw);
                    unmatchedIndex.put(k, currentChars);
                }

                removeNotMostMatchingWord(wordSet);
            }
        }
    }

    private void removeNotMatchingWord(Set<String> currentWords) {
        Set<String> removeUnmatch = new HashSet<>();
        for (String word : currentWords) {
            for (int k = 0 ; k < word.length();k++) {
                if (matchingChars.containsKey(k) && matchingChars.get(k) != word.charAt(k)) {
                    removeUnmatch.add(word);
                    break;
                }
            }
        }

        currentWords.removeAll(removeUnmatch);
    }

    private void removeNotMostMatchingWord(Set<String> currentWords) {
        Set<String> removeUnmatch = new HashSet<>();
        for (String word : currentWords) {
            for (int k = 0 ; k < word.length();k++) {
                Set<Character> rejectedChars = unmatchedIndex.get(k);
                if (rejectedChars.contains(word.charAt(k))) {
                    removeUnmatch.add(word);
                    break;
                }
            }
        }

        currentWords.removeAll(removeUnmatch);
    }

    private void cleanNotMatching(Set<String> currentWords, String guessedWord, int currentMatchCount) {

        if (!currentWords.isEmpty()) {
            Set<String> removeUnmatch = new HashSet<>();
            for (String word: currentWords) {
                int matchingCount = 0;
                for (int k = 0 ; k < word.length();k++) {
                    if (word.charAt(k) == guessedWord.charAt(k)) {
                        matchingCount++;
                    }
                }
                if (matchingCount == 0) {
                    removeUnmatch.add(word);
                }
            }

            if (removeUnmatch.size() > 0) {
                currentWords.removeAll(removeUnmatch);
            }
        }
    }

}
