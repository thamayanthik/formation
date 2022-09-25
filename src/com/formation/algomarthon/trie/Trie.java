package com.formation.algomarthon.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
    }

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode currentNode = root;
        char[] ca = word.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (!currentNode.childrens.containsKey(ca[i])) {
                currentNode.childrens.put(ca[i], new TrieNode());
            }
            currentNode = currentNode.childrens.get(ca[i]);
        }

        currentNode.isEnd = true;

    }

    public boolean search(String word) {

        TrieNode currentNode = root;
        if (currentNode == null || (currentNode != null && !currentNode.childrens.containsKey(word.charAt(0)))) {
            return  false;
        } else {
            int index = 0;
            while (index < word.length()) {
                if (currentNode.childrens.containsKey(word.charAt(index))) {
                    currentNode = currentNode.childrens.get(word.charAt(index));
                } else {
                    return false;
                }

                index++;
            }

            if (!currentNode.isEnd) {
                return false;
            }
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        if (currentNode == null || (currentNode != null && !currentNode.childrens.containsKey(prefix.charAt(0)))) {
            return  false;
        } else {
            int index = 0;
            while (index < prefix.length()) {
                if (currentNode.childrens.containsKey(prefix.charAt(index))) {
                    currentNode = currentNode.childrens.get(prefix.charAt(index));
                } else {
                    return false;
                }

                index++;
            }
        }

        return true;
    }
}