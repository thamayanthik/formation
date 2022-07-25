package com.formation.algoblitz.binarytree;

import com.formation.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindDirectReport {
    public static void main(String[] args) {
        TreeNode c1 = new TreeNode(2, null, null);
        TreeNode c2 = new TreeNode(3, null, null);
        TreeNode c3 = new TreeNode(1, c1, c2);
        TreeNode head = new TreeNode(1, c3, null);
        System.out.println(isDirectReport(head, 1, 4));
    }

    private static boolean isDirectReport(TreeNode head, int a, int b) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null && a == currentNode.value && currentNode.left.value == b) {
                return true;
            } else if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null && a == currentNode.value && currentNode.right.value == b) {
                return true;
            } else if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }


        return false;
    }
}
