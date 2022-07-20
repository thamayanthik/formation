package com.formation.algoblitz.DFS;

import com.formation.util.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MostFrequentElement {
    public static void main(String[] args) {
        System.out.println(mostFrequentElement(new TreeNode(1, null, null)));

        TreeNode c0 = new TreeNode(2, null, null);
        TreeNode c11 = new TreeNode(3, null, null);
        TreeNode c1 = new TreeNode(2, c0, null);
        TreeNode c2 = new TreeNode(3, c1, null);
        TreeNode c3 = new TreeNode(3, null, c11);
        TreeNode c4 = new TreeNode(4, c3, c2);
        TreeNode c5 = new TreeNode(4, c4, null);

        System.out.println(mostFrequentElement(c5));
    }

    private static int mostFrequentElement(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        Map<Integer, Integer> frequencyCount = new HashMap<>();
        int maxFrequent = Integer.MIN_VALUE;
        Integer elementValue = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = frequencyCount.getOrDefault(node.value, 0) + 1;
            frequencyCount.put(node.value, count);
            if (count > maxFrequent) {
                elementValue = node.value;
                maxFrequent = count;
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return elementValue;
    }
}
