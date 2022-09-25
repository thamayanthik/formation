package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, sl2);
        TreeNode sr2 = new TreeNode(4, null, sr1);

        TreeNode fr = new TreeNode(3, null, sr2);
        TreeNode head = new TreeNode(2, null, fr);

        System.out.println(minDepth(head));
    }

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

}
