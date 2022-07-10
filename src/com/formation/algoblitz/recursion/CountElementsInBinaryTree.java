package com.formation.algoblitz.recursion;

import com.formation.util.TreeNode;

public class CountElementsInBinaryTree {
    public static void main(String[] args) {
        TreeNode l2 = new TreeNode(5, null, null);
        TreeNode r2 = new TreeNode(4, null, null);

        TreeNode l1 = new TreeNode(7, l2, r2);
        TreeNode r1 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, l1, r1);
        int count = countElement(root);
        System.out.println(count);

    }

    private static int countElement(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + countElement(root.left) + countElement(root.right);
        }
    }
}
