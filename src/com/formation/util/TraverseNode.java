package com.formation.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraverseNode {
    public static List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            order.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            } else {
                order.add(null);
            }
            if (node.left != null) {
                stack.push(node.left);
            } else {
                order.add(null);
            }
        }

        return order;
    }
}
