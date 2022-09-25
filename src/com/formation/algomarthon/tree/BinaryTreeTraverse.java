package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

public class BinaryTreeTraverse {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(1, fl, fr);

        preOrderTraverse(root);
    }

    private static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }
}
