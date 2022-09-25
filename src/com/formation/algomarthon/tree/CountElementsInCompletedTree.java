package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountElementsInCompletedTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sl2);
        TreeNode fr = new TreeNode(3, sr1, sr2);
        TreeNode head = new TreeNode(1, fl, fr);

        System.out.println(countNodes(head));
    }

    public static int countNodes(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        } else {
            return 0;
        }

        // DFS
        int maxDepth = 0;
        int leafNodeCount = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (node.level > maxDepth - 1) {
                    leafNodeCount++;
                }
            } else {
                int childNodeLevel = node.level + 1;
                maxDepth = Math.max(maxDepth, childNodeLevel);
                if (node.right != null) {
                    node.right.level = childNodeLevel;
                    stack.push(node.right);
                }

                if (node.left != null) {
                    node.left.level = childNodeLevel;
                    stack.push(node.left);
                }
            }
        }

        int result = 0;
        if (maxDepth > 0) {
            result = (int) (Math.pow(2, maxDepth)) - 1;
        }

        result += leafNodeCount;

        return result;
    }
}
