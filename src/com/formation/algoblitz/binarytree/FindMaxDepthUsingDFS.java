package com.formation.algoblitz.binarytree;

import com.formation.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindMaxDepthUsingDFS {
    public static void main(String[] args) {
        TreeNode c12 = new TreeNode(10, null, null);
        TreeNode c11 = new TreeNode(10, c12, null);
        TreeNode c1 = new TreeNode(2, c11, null);
        TreeNode c2 = new TreeNode(4, null, null);
        TreeNode head = new TreeNode(1, c1, c2);
        System.out.println(maxDepthDFS(head));
        /*
                1
               / \
              2   4
             / \ / \
           10
          /
         10
         */
    }

    public static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int elementSize = stack.size();
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            for (int i = 0; i < elementSize; i++) {
                TreeNode node = stack.pop();
                rightNode = node.right;
                leftNode = node.left;
            }

            if (leftNode != null) {
                stack.add(leftNode);
            }
            if (rightNode != null) {
                stack.add(rightNode);
            }

            max++;
        }
        return max;
    }
}
