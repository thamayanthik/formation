package com.formation.algoblitz.binarytree;

import com.formation.util.TreeNode;

import java.util.Stack;

public class SumNodesWithEvenParent {
    public static void main(String[] args) {
        TreeNode lc = new TreeNode(5, null, null);
        TreeNode rc = new TreeNode(9, null, null);
        TreeNode head = new TreeNode(2, lc, rc);
        System.out.println(sumNodesWithEvenParent(head));

        System.out.println(sumNodesWithEvenParent(new TreeNode(2, null, null)));
    }

    private static int sumNodesWithEvenParent(TreeNode head) {
        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        if (head != null && head.value % 2 == 0) {
            s.push(head);
        }
        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();

            if (currentNode.left != null) {
                sum += currentNode.left.value;
                if (currentNode.left.value % 2 == 0) {
                    s.push(currentNode.left);
                }
            }

            if (currentNode.right != null) {
                sum += currentNode.right.value;
                if (currentNode.right.value % 2 == 0) {
                    s.push(currentNode.right);
                }
            }
        }
        return sum;
    }
}
