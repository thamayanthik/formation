package com.formation.algomarthon.recursion;

import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfLeftLeafNode {
    public static void main(String[] args) {

        TreeNode sl1 = new TreeNode(4, null, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(1, fl, fr);

        List<Integer> leafNodes = findAllLeftLeafNodes(root, new ArrayList<>());
        int sum = leafNodes.stream().reduce(0, (total, i) -> total + i);
        System.out.println("Sum : " + sum);
    }

    private static List<Integer> findAllLeftLeafNodes(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            result.add(root.left.value);
        }

        findAllLeftLeafNodes(root.left, result);
        findAllLeftLeafNodes(root.right, result);

        return result;
    }
}
