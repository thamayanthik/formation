package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.Arrays;

/**
 *Given an array of integers sorted in ascending order, convert it to a height balanced BST.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * You must pick the smaller number when picking the "middle." In other words, when there are two numbers to choose from to pick the next child node, choose the smaller value (see example below).
 * Example:
 *
 * Given an array: [-10,-3,0,5,9]
 * // returns:
 *
 *                 0
 *                / \
 *              -10   5
 *                \    \
 *                -3    9
 *
 * 1. Choose 0 as a root node.
 * 2. For left child node of 0, you have -10 and -3. According to the rule, you choose the smaller value -10.
  */
public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        TreeNode head = constructBST(new int[]{-10, -3, 0, 5, 9});
        head.inOrder();
    }

    private static TreeNode constructBST(int[] arr) {
        if (arr.length > 0) {
            int mid = arr.length / 2;
            TreeNode node = new TreeNode(arr[mid], null, null);
            node.left = constructBST(Arrays.copyOfRange(arr, 0, mid));
            node.right = constructBST(Arrays.copyOfRange(arr, mid + 1, arr.length));
            return node;
        }
        return null;
    }

    private static TreeNode constructTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(arr[mid], null, null);

        node.left = constructTree(arr, start, mid - 1);

        node.right = constructTree(arr, mid + 1, end);

        return node;
    }
}
