package com.formation.algomarthon.codesignal;

import com.formation.util.TreeNode;

public class FindKthElementInBinaryTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sl2);
        TreeNode fr = new TreeNode(3, sr1, sr2);
        TreeNode head = new TreeNode(1, fl, fr);

        System.out.println(inOrderTraversal(head, 0, 2));
    }

    public static Integer inOrderTraversal(TreeNode root, int nodeCount, int k) {
        Integer kthSmallest = null;
        if (root != null) {
            if (nodeCount == k) {
                return root.value;
            }
            nodeCount++;
            kthSmallest = inOrderTraversal(root.left, nodeCount, k);
            if (kthSmallest == null) {
                kthSmallest = inOrderTraversal(root.left, nodeCount, k);
            }
        }

        return kthSmallest;
    }
}
