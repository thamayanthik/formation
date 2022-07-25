package com.formation.algoblitz.binarytree;

import com.formation.util.TreeNode;

import java.util.Stack;

public class ImmediateDistinctTree {
    public static void main(String[] args) {
        TreeNode c1 = new TreeNode(2, null, null);
        TreeNode c2 = new TreeNode(3, null, null);
        TreeNode c3 = new TreeNode(1, c1, c2);
        TreeNode head = new TreeNode(1, c3, null);
        System.out.println(isImmediateDistinctTree(head));
    }

    private static boolean isImmediateDistinctTree(TreeNode head) {
        Stack<TreeNode> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            if (currentNode.left != null && currentNode.left.value == currentNode.value) {
                return false;
            } else if (currentNode.left != null) {
                s.push(currentNode.left);
            }

            if (currentNode.right != null && currentNode.right.value == currentNode.value) {
                return false;
            } else if (currentNode.right != null) {
                s.push(currentNode.right);
            }
        }

        return true;
    }
}
