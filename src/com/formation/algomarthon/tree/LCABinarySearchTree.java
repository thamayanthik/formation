package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

public class LCABinarySearchTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(3, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(9, null, null);

        TreeNode sr1 = new TreeNode(6, null, null);
        TreeNode sr2 = new TreeNode(9, null, null);

        TreeNode fl = new TreeNode(5, sl1, sr1);
        TreeNode fr = new TreeNode(12, sl2, sr2);
        TreeNode root = new TreeNode(8, fl, fr);

        System.out.println(findlca(root, 5, 12));
    }

    private static int findlca(TreeNode root, int p, int q) {
        int parent = root.value;

        if (p < parent && q < parent) {
            return findlca(root.left, p, q);
        } else if (p > parent && q > parent) {
            return findlca(root.right, p, q);
        } else {
            return parent;
        }
    }
}
