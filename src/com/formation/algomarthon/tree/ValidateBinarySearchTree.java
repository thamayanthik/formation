package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

/*
Given a binary search tree, return the value of the violating node. When there is a violation, return the lowest node. If there is no violating node, return -1.

The properties of a binary search tree are that:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A violating node occurs when one of these properties is not met.

For example, in this tree:

      5
    /  \
  2    10
   \
    8
We have a violation between 5 and 8 because 8 is not less than 5. Because 8 is the lower node, return 8.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    private static int findViolatingNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return -1;
    }
}
