package com.formation.algomarthon.codesignal;

import com.formation.util.TreeNode;

import java.util.Arrays;

public class PrintAllPathInBinaryTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode head = new TreeNode(1, fl, fr);

        System.out.println(Arrays.deepToString(printRootToLeaf(head, new Integer[100], 0)));
    }

    private static String[] printRootToLeaf(TreeNode root, Integer[] nodeValues, int index) {

        if (root == null) {
            return new String[] {};
        }

        nodeValues[index++] = root.value;

        if (root.right == null && root.left == null) {
            String[] path = new String[1];
            String pathValue = "";
            for (int i = 0; i < index - 1; i++) {
                pathValue += nodeValues[i] + "->";
            }

            pathValue += nodeValues[index - 1];

            path[0] = pathValue;
            return path;
        }

        String[] leftValues = printRootToLeaf(root.left, nodeValues, index);
        String[] rightValues = printRootToLeaf(root.right, nodeValues, index);

        String[] result = new String[leftValues.length + rightValues.length];
        int mergeIndex = 0;
        for (int i = 0; i < leftValues.length; i++) {
            result[mergeIndex] = leftValues[i];
            mergeIndex++;
        }

        for (int i = 0; i < rightValues.length; i++) {
            result[mergeIndex] = rightValues[i];
            mergeIndex++;
        }

        return result;
    }
}
