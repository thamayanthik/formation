package com.formation.algomarthon.tree;

import com.formation.algomarthon.trie.Trie;

public class TrieImplementation {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.startsWith("dd"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
    }
}
