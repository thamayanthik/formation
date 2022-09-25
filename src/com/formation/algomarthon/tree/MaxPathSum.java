package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

/*
Given a non-empty binary tree, find the maximum path sum.

A path is any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.
Example:

Given a tree:
           1
          / \
         2   3
        /
      -1
// returns 6 (1 + 2 + 3)

 */
public class MaxPathSum {
    private static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {

        TreeNode fl = new TreeNode(2, new TreeNode(-1, null, null), null);
        TreeNode fr = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, fl, fr);

        maxPathSum(root);
        System.out.println(maxSum);
    }

    private static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(maxPathSum(root.left), 0);
        int rightMax = Math.max(maxPathSum(root.right), 0);

        int currentTotal = root.value + leftMax + rightMax;

        maxSum = Math.max(maxSum, currentTotal);

        return root.value + Math.max(leftMax, rightMax);
    }
}
