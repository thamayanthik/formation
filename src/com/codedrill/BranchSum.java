package com.codedrill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSum {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree leaf1 = new BinaryTree(8);
        BinaryTree leaf2 = new BinaryTree(9);
        BinaryTree leaf3 = new BinaryTree(10);

        BinaryTree l21 = new BinaryTree(4);
        l21.left = leaf1;
        l21.right = leaf2;

        BinaryTree l22 = new BinaryTree(5);
        l22.left = leaf3;

        BinaryTree l23 = new BinaryTree(2);
        l23.left = l21;
        l23.right = l22;

        BinaryTree l24 = new BinaryTree(3);
        l24.left = new BinaryTree(6);
        l24.right = new BinaryTree(7);

        BinaryTree root = new BinaryTree(1);
        root.left = l23;
        root.right = l24;

        System.out.println(branchSums(root));
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        sum(root, 0, result);
        return result;
    }

    private static void sum(BinaryTree root,
                            int runningSum, List<Integer> result) {

        runningSum +=  root.value;
        if (root.left == null && root.right == null) {
            result.add(runningSum);
        }

        if (root.left != null) {
            sum(root.left, runningSum, result);
        }

        if (root.right != null) {
            sum(root.right, runningSum, result);
        }
    }
}
