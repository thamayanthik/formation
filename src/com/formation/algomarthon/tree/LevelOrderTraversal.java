package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(3, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(9, null, null);

        TreeNode sr1 = new TreeNode(6, null, null);
        TreeNode sr2 = new TreeNode(9, null, null);

        TreeNode fl = new TreeNode(5, sl1, sr1);
        TreeNode fr = new TreeNode(12, sl2, sr2);
        TreeNode root = new TreeNode(8, fl, fr);
        System.out.println(root.toString());
        levelOrderIterative(root);
        System.out.println();
        System.out.println("Recursion....");
        levelOrderRecursive(root, null);
    }

    private static void levelOrderIterative(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                while (size > 0) {
                    TreeNode node = stack.pop();
                    System.out.print(node.value + " ");
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                    size--;
                }
            }
        }
    }

    private static void levelOrderRecursive(TreeNode root, Deque<TreeNode> stack) {
        if (stack == null) {
            stack = new ArrayDeque<>();
            stack.push(root);
        }

        if (stack.isEmpty()) {
            return;
        }

        int size = stack.size();

        while (size > 0) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            size--;
        }

        levelOrderRecursive(root, stack);
    }
}
