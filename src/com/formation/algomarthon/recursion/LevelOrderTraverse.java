package com.formation.algomarthon.recursion;

import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraverse {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(1, fl, fr);

        int max = maxDepth(root);
        System.out.println("MaxDepth : " + max);

        for (int i = max; i >= 1; i--) {
            printNodeByLevel(root, i);
        }

        System.out.println();

        for (int i = max; i >= 1; i--) {
            System.out.println("Values By Level " + i + " : " + getValuesByLevel(root, i, new ArrayList<>()));
        }

        for (int i = max; i >= 1; i--) {
            System.out.println("Total By Level " + i + " : " + findSumByLevel(root, i, 0));
        }
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static void printNodeByLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.value + " ");
        } else {
            printNodeByLevel(root.left, level - 1);
            printNodeByLevel(root.right, level - 1);
        }
    }

    private static List<Integer> getValuesByLevel(TreeNode root, int level, List<Integer> values) {
        if (root == null) {
            return values;
        }

        if (level == 1) {
            values.add(root.value);
        }

        getValuesByLevel(root.left, level - 1, values);
        getValuesByLevel(root.right, level - 1, values);

        return values;
    }

    private static int findSumByLevel(TreeNode root, int level, int sum) {
        if (root == null) {
            return sum;
        }

        if (level == 1) {
            sum += root.value;
            return sum;
        }

        int leftSum = findSumByLevel(root.left, level - 1, sum);
        int rightSum = findSumByLevel(root.right, level - 1, sum);

        return leftSum + rightSum;
    }
}
