package com.formation.algomarthon.recursion;

import com.formation.util.TreeNode;

public class FindMinInBST {

    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(10, fl, fr);

        System.out.println(findMin(root));
    }

    private static int findMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(node.value, Math.min(findMin(node.left), findMin(node.right)));
    }
}
