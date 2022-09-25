package com.formation.session.pairlearning;

/*
Given a binary tree, return the sum of all nodes with an odd-valued parent node.
Target runtime and space complexity:
      O(n), where n = # of nodes in tree

Examples:
[6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5] => 19

 */

public class SumOfOddValueParent {
    public static class Tree {
        int value;
        Tree left;
        Tree right;
        Tree(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.right.left = new Tree(2);
        root.right.right = new Tree(2);
        System.out.println(dfs(root));
    }

    public static int dfs(Tree node){
        if(node == null) return 0;

        if(node.value %2 != 0){
            return node.left.value + node.right.value + dfs(node.left) + dfs(node.right);
        } else {
            return dfs(node.left) + dfs(node.right);
        }

    }
}
