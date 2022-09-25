package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

public class NumberOfMatchingTarget {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(2, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(1, fl, fr);

        System.out.println(countNumberElementMatchTarget(root, 2));
    }

    private static Integer countNumberElementMatchTarget(TreeNode node, int target) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        if (target == node.value) {
            res += 1;
        }
        return  res + countNumberElementMatchTarget(node.left, target)
                + countNumberElementMatchTarget(node.right, target);
    }
}
