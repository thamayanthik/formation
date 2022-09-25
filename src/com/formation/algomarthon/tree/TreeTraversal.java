package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(1, fl, fr);
        System.out.print("InOrder : ");
        inOrderTraverse(root);
        System.out.println();
        System.out.print("PreOrder : ");
        preOrderTraverse(root);
        System.out.println();
        System.out.print("PostOrder : ");
        postOrderTraverse(root);
        System.out.println();
        System.out.print("Path : ");
        generateAllPathUsingInOrder(root, new ArrayList<>());
        System.out.println();
        System.out.print("Path (K) : ");
        generateAllPathUsingInOrderByK(root, new ArrayList<>(), 5);
        System.out.println();
        System.out.print("Path (K) : ");
        generateAllPathUsingInOrderByK(root, new ArrayList<>(), 8);
    }

    /*
     *                        1
     *                  2             3
     *            4           5     6     7
     *         8
     *
     *   InOrder:   8 4 2 5 1 6 3 7  [left, root, right]
     *   PreOrder:  1 2 4 8 5 3 6 7  [root, left, right]
     *   PostOrder: 8 4 5 2 6 7 3 1  [left, right, root]
     *
     *
     */
    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.value + " ");
            inOrderTraverse(root.right);
        }
    }

    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.value + " ");
        }
    }

     /*
     *                        1
     *                  2             3
     *            4           5     6     7
     *         8
     *
     */
    public static void generateAllPathUsingInOrder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.value);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        }

        generateAllPathUsingInOrder(root.left, path);

        generateAllPathUsingInOrder(root.right, path);

        path.remove(path.size() - 1);
    }

    public static void generateAllPathUsingInOrderByK(TreeNode root, List<Integer> path, int k) {

        if (root == null) {
            return;
        }

        path.add(root.value);

        if (path.contains(k)) {
            System.out.println(path);
        }

        generateAllPathUsingInOrderByK(root.left, path, k);

        generateAllPathUsingInOrderByK(root.right, path, k);

        path.remove(path.size() - 1);
    }
}
