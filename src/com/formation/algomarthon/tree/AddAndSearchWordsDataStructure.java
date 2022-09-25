package com.formation.algomarthon.tree;

import com.formation.algomarthon.trie.WordDictionary;

public class AddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pot");
        wordDictionary.addWord("bake");

        System.out.println("LookFor pad : " + wordDictionary.search("pad")); // return False
        System.out.println("LookFor bad : " + wordDictionary.search("bad")); // return True
        System.out.println("LookFor .ad : " + wordDictionary.search(".ad")); // return True
        System.out.println("LookFor b.. : " + wordDictionary.search("b..")); // return True
        System.out.println("LookFor p.t : " + wordDictionary.search("p.t")); // return True
        System.out.println("LookFor b.k. : " + wordDictionary.search("b.k.")); // return True
        System.out.println("------------------------------------------");
        /**
         * ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
         * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
         * [null,null,null,null,null,false,false,null,true,true,false,false,true,false]
         */
        wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        System.out.println("LookFor .at : " + wordDictionary.search("a")); // return False


    }
}
