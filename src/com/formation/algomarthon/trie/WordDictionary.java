package com.formation.algomarthon.trie;

import com.formation.algomarthon.trie.TrieNode;

public class WordDictionary {
    TrieNode trieNode = null;

    public WordDictionary() {
        trieNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currentNode = trieNode;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.childrens.containsKey(word.charAt(i))) {
                currentNode.childrens.put(word.charAt(i), new TrieNode());
            }
            currentNode = currentNode.childrens.get(word.charAt(i));
        }

        currentNode.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = trieNode;
        return dfs(word, currentNode);
    }

    private boolean dfs(String word, TrieNode currentNode) {
        if (!word.isEmpty()) {
            if (word.charAt(0) == '.') {
                for (TrieNode node : currentNode.childrens.values()) {
                    boolean found = dfs(word.substring(1), node);
                    if (found) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!currentNode.childrens.containsKey(word.charAt(0))) {
                    return false;
                }
                currentNode = currentNode.childrens.get(word.charAt(0));
                return dfs(word.substring(1), currentNode);
            }
        }

        return currentNode != null && currentNode.isEnd;
    }
}
