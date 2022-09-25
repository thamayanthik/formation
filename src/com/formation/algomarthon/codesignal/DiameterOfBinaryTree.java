package com.formation.algomarthon.codesignal;

import com.formation.util.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode head = new TreeNode(1, fl, fr);

        System.out.println(calculateDiameter(head));

      //  System.out.println(height(head));
    }

    private static int calculateDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate heights (left and right)
        int lh = height(root.left);
        int rh = height(root.right);

        //System.out.println("Node " + root.value + ", lh : " + lh + ", rh : " + rh);

        // find diameters of left and right
        int ld = calculateDiameter(root.left);
        int rd = calculateDiameter(root.right);

        //System.out.println("Node " + root.value + ", ld : " + ld + ", rd : " + rd);

        // To find diameter, return max of lh + rh + 1 (includes root), max of (ld, rd)

        int diameter = Math.max((lh + rh + 1), Math.max(ld, rd));

       // System.out.println("Node " + root.value + ", diameter : " + diameter);

        return diameter;
    }


    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }
}
