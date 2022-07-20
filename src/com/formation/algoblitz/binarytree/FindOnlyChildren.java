package com.formation.algoblitz.binarytree;

import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

public class FindOnlyChildren {
    public static void main(String[] args) {
        System.out.println(findOnlyChildren(new TreeNode(1, new TreeNode(2, null, null), null)));

        TreeNode c1 = new TreeNode(2, null, null);
        TreeNode c2 = new TreeNode(4, null, null);
        TreeNode c3 = new TreeNode(3, null, c2);
        TreeNode head = new TreeNode(1, c1, c3);
        System.out.println(findOnlyChildren(head));
    }

    private static List<Integer> findOnlyChildren(TreeNode head) {
        List<Integer> onlyChildren = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        s.push(head);

        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            if (currentNode.left == null && currentNode.right != null) {
                onlyChildren.add(currentNode.right.value);
                s.push(currentNode.right);
            } else if (currentNode.right != null) {
                s.push(currentNode.right);
            }
            if (currentNode.left != null && currentNode.right == null) {
                onlyChildren.add(currentNode.left.value);
                s.push(currentNode.left);
            } else if (currentNode.left != null) {
                s.push(currentNode.left);
            }
        }


        return onlyChildren;
    }
}
