package com.formation.algomarthon.backtracking;

import com.formation.algomarthon.trie.Trie;
import com.formation.algomarthon.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

/*
Test Data:

[["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
["oa","oaa"]

[["a","b","c"],["a","e","d"],["a","f","g"]]
["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]

Expected: ["abcdefg","befa","eaabcdgfa","gfedcbaaa"]

{"oa", "oaa"}
{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}


String[] words = {"eaabcdgfa"};
        char[][] board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};


[["a","b","c"],["a","e","d"],["a","f","g"]]
["eaafgdcba","eaabcdgfa"]

Expected : ["eaabcdgfa","eaafgdcba"]
 */

public class WordSearch {
    public static void main(String[] args) {

        /*String[] words = {"oa", "oaa"};
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};*/
     /*   String[] words = {"aaa"};
        char[][] board = new char[][]{{'a', 'a'}};*/
        String[] words = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        char[][] board = new char[][]{{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}};
        System.out.println(findWordByTrie(board, words));
    }

    private static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean find = false;
            for (int i = 0; i < board.length && !find; i++) {
                for (int j = 0; j < board[i].length && !find; j++) {
                    System.out.println("Processing Started i : " + i + ", j : " + j);
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    if (searchWord(board, word, "", i, j, 0, visited, "start")) {
                        find = true;
                    }
                }
            }
            System.out.println("Word : " + word + " Found : " + find);
            if (find) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean searchWord(char[][] board, String word,
                                      String ans, int r, int c, int k, boolean[][] visited, String direction) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length || k >= word.length() || visited[r][c]) {
            System.out.println("Inside exit r : " + r + ", c : " + c + ", k : " + k);
            return false;
        }

        System.out.println("r : " + r + ", c : " + c + ", k : " + k + ", board : " + board[r][c] + ", direction : " + direction);

        if (board[r][c] == word.charAt(k)) {
            System.out.println("match found : " + word.charAt(k));
            visited[r][c] = true;
            if (k == word.length() - 1) {
                return true;
            } else if (searchWord(board, word, ans + board[r][c], r - 1, c, k + 1, visited, "up") ||
                    searchWord(board, word, ans + board[r][c], r + 1, c, k + 1, visited, "down") ||
                    searchWord(board, word, ans + board[r][c], r, c - 1, k + 1, visited, "right") ||
                    searchWord(board, word, ans + board[r][c], r, c + 1, k + 1, visited, "left")) {
                visited[r][c] = false;
                System.out.println("Backtrack : " + r + ", c : " + c);
                return true;
            }
        } else {
            System.out.println("match not found : " + word.charAt(k));
        }

        return false;
    }

    /*
    using trie
     */

    private static List<String> findWordByTrie(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, visited, result, "", i, j, trie.getRoot());
            }
        }
        return result;
    }

    public static void dfs(char[][] board, boolean[][] visited, List<String> result,
                           String str, int i, int j, TrieNode trie) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
                || !trie.childrens.containsKey(board[i][j])) {
            return;
        }
       /* if (!trie.startsWith(str))
            return;

        if (!result.contains(str) && trie.search(str)) {
            result.add(str);
        }*/

        visited[i][j] = true;

        trie = trie.childrens.get(board[i][j]);
        str += board[i][j];
        if (trie.isEnd && !result.contains(str)) {
            result.add(str);
        }

        dfs(board, visited, result, str, i - 1, j, trie);
        dfs(board, visited, result, str, i + 1, j, trie);
        dfs(board, visited, result, str, i, j - 1, trie);
        dfs(board, visited, result, str, i, j + 1, trie);
        visited[i][j] = false;
    }

}

