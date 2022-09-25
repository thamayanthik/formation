package com.formation.algomarthon.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> childrens = new HashMap<>();
    public boolean isEnd;
}
