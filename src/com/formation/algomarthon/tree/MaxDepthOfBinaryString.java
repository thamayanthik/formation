package com.formation.algomarthon.tree;
/*
You are given a binary tree that is represented by a string. Nodes have no value. A 0 represents null and a (00) represents a node with no children, a leaf node. ((00)0) would represent a tree where the root has one left node and no right node. ((00)(00)) represents a tree with one left and one right node.
        Given this representation of the tree, return the maximum depth of the tree.

        ((00)(00))

        ( )
        /     \
        (00)  (00)


        ((00)0)

        ( )
        /   \
        (00)  null
*/

/**
 * Each opening bracket is considered as one level up, and closing bracket considers one level down.
 */
public class MaxDepthOfBinaryString {
    public static void main(String[] args) {
        String str = "((00)(00))";
        System.out.println(maxDepth(str));
    }

    private static int maxDepth(String str) {
        int maxDepth  = Integer.MIN_VALUE;

        int currentCount = 0;
        for (char c :  str.toCharArray()) {
            if (c == '(') {
                currentCount++;
                maxDepth = Math.max(maxDepth, currentCount);
            } else if (c == ')') {
                currentCount--;
                if (currentCount < 0) return -1;
            }
        }

        return maxDepth;
    }
}
