package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLCABinaryTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(3, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(9, null, null);

        TreeNode sr1 = new TreeNode(6, null, null);
        TreeNode sr2 = new TreeNode(13, null, null);

        TreeNode fl = new TreeNode(5, sl1, sr1);
        TreeNode fr = new TreeNode(12, sl2, sr2);
        TreeNode root = new TreeNode(8, fl, fr);

        System.out.println(findLCASolution1(root, 9, 13));

        System.out.println(findLcaSolution2(root, 9, 13));
    }

    /*
     Find the path for 2 numbers and find common value
     */
    private static int findLCASolution1(TreeNode node, int p, int q) {
        List<Integer> pPath = findPath(node, p, new ArrayList<>());
        List<Integer> qPath = findPath(node, q, new ArrayList<>());

        System.out.println("pPath : " + pPath + ", qPath : " + qPath);

        int lca = -1;
        int pi = 0, qi = 0;
        while (pi < pPath.size() && qi < qPath.size()) {
            if (pPath.get(pi) != qPath.get(qi)) {
                break;
            }
            lca = pPath.get(pi);
            pi++;
            qi++;
        }

        return lca;
    }

    private static List<Integer> findPath(TreeNode node, int target, List<Integer> ans) {
        if (node == null) {
            return null;
        }

        ans.add(node.value);

        if (node.value == target) {
            return List.copyOf(ans);
        }

        List<Integer> leftPath = findPath(node.left, target, ans);
        if (leftPath == null || !leftPath.contains(target)) {
            List<Integer> rightPath = findPath(node.right, target, ans);
            ans.remove(ans.size() - 1);
            return rightPath;
        }

        return leftPath;

    }

    private static Integer findLcaSolution2(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }

        if (node.value == p || node.value == q) {
            return node.value;
        }

        Integer left = findLcaSolution2(node.left, p, q);
        Integer right = findLcaSolution2(node.right, p, q);

        if (left != null && right != null) {
            return node.value;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
