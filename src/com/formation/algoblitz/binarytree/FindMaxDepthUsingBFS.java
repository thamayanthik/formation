package com.formation.algoblitz.binarytree;

import com.formation.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxDepthUsingBFS {
    public static void main(String[] args) {
        System.out.println(maxDepthBFS(new TreeNode(1, new TreeNode(2, null, null), null)));
        System.out.println(maxDepthUsingRecursion(new TreeNode(1, new TreeNode(2, null, null), null)));
    }

    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qs = queue.size();
            for (int i = 0; i < qs; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            max++;
        }
        return max;
    }

    public static int maxDepthUsingRecursion(TreeNode root) {
        if (root == null) return 0;
        int leftCount  = 1 + maxDepthUsingRecursion(root.left);
        int rightCount = 1 + maxDepthUsingRecursion(root.right);

        return Math.max(leftCount, rightCount);
    }
}
