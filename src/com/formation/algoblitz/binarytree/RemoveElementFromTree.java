package com.formation.algoblitz.binarytree;

import com.formation.util.TraverseNode;
import com.formation.util.TreeNode;

import java.util.Stack;

public class RemoveElementFromTree {
    public static void main(String[] args) {
        TreeNode c12 = new TreeNode(10, null, null);
        TreeNode c11 = new TreeNode(10, c12, null);
        TreeNode c1 = new TreeNode(2, c11, null);
        TreeNode c2 = new TreeNode(4, null, null);
        TreeNode head = new TreeNode(1, c1, c2);
        removeElement(head, 10);
        removeElement(head, 1);
    }

    private static TreeNode removeElement(TreeNode head, int target) {
        Stack<TreeNode> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.value == target) {
                head = null;
            } else {
                if (node.left != null && node.left.value == target) {
                    node.left = null;
                } else if (node.left != null) {
                    s.push(node.left);
                }

                if (node.right != null && node.right.value == target) {
                    node.right = null;
                } else if (node.right != null) {
                    s.push(node.right);
                }
            }
        }

        System.out.println(TraverseNode.preOrder(head));

        return head;
    }
}
