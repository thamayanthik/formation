package com.formation.algoblitz.binarytree;

import com.formation.util.TraverseNode;
import com.formation.util.TreeNode;

import java.util.Stack;

public class FlipTheTree {
    public static void main(String[] args) {
        TreeNode c12 = new TreeNode(10, null, null);
        TreeNode c11 = new TreeNode(10, c12, null);
        TreeNode c1 = new TreeNode(2, c11, null);
        TreeNode c2 = new TreeNode(4, null, null);
        TreeNode head = new TreeNode(1, c1, c2);
        System.out.println(TraverseNode.preOrder(head));
        flipTree(head);
        System.out.println(TraverseNode.preOrder(head));
    }

    private static TreeNode flipTree(TreeNode head) {
        Stack<TreeNode> s = new Stack<>();
        s.push(head);

        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            TreeNode tmp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = tmp;
            if (currentNode.left != null) {
                s.push(currentNode.left);
            }

            if (currentNode.right != null) {
                s.push(currentNode.right);
            }
        }

        return head;
    }
}
