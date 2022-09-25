package com.formation.util;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public int level;

    public TreeNode(int v, TreeNode l, TreeNode r) {
        value = v;
        left = l;
        right = r;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);

        if (left != null) {
            sb.append("->");
            sb.append(left.toString());
        }

        if (right != null) {
            sb.append("->");
            sb.append(right.toString());
        }

        return sb.toString();
    }

    public void inOrder() {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(this);
        System.out.print("Printing Tree : ");
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.value + " ");
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        System.out.println();
    }
}
