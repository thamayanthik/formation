package com.formation.algoblitz.binarytree;

import com.formation.util.TraverseNode;
import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParentSumTree {
    public static void main(String[] args) {
        TreeNode head = parentSumTree(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(4, null, null)));
        System.out.println(TraverseNode.preOrder(head));
    }

    private static TreeNode parentSumTree(TreeNode head) {

        Stack<TreeNode> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            if (currentNode.left != null) {
                currentNode.left.value += currentNode.value;
                s.push(currentNode.left);
            }

            if (currentNode.right != null) {
                currentNode.right.value += currentNode.value;
                s.push(currentNode.right);
            }
        }

        return head;
    }
}
