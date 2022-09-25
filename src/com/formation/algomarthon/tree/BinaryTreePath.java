package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, tl1, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, sr1);
        TreeNode fr = new TreeNode(3, sl2, sr2);
        TreeNode root = new TreeNode(1, fl, fr);

        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        return treePath(root, new String(), new ArrayList<>());
    }

    private static List<String> treePath(TreeNode root, String paths, List<String> result) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            paths += root.value;
            result.add(paths);
        } else {
            paths += root.value + "->";
        }

        treePath(root.left, paths, result);
        treePath(root.right, paths, result);

        return result;
    }
}
