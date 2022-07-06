package com.formation.algoblitz.linkedlist;

public class FindMaxValue {
    public static void main(String[] args) {
        int maxValue = findMaxValue(NodeCreationHelper.createNode(8));

        System.out.println("Result : " + maxValue);

        maxValue = findMaxValueUsingRecursion(NodeCreationHelper.createNode(8), Integer.MIN_VALUE);

        System.out.println("Result Using Recursion : " + maxValue);

    }

    private static int findMaxValue(Node node) {
        int max = Integer.MIN_VALUE;

        while (node != null) {
            max = Math.max(max, node.value);
            node = node.next;
        }

        return max;
    }

    private static int findMaxValueUsingRecursion(Node node, int max) {
        if (node == null) {
            return max;
        } else {
            if (max < node.value) {
                max = node.value;
            }

            return findMaxValueUsingRecursion(node.next, max);
        }
    }
}
