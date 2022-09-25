package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

import java.util.*;

public class MakeForest {
    public static void main(String[] args) {
        TreeNode c1 = new TreeNode(4, null, null);
        TreeNode c2 = new TreeNode(3, null, null);
        TreeNode c3 = new TreeNode(2, c1, c2);
        TreeNode head = new TreeNode(1, c3, new TreeNode(5, null, null));

        delNodesRecursive(head, new int[] {2});
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> forest = new ArrayList<>();
        List<Integer> deleteNodes = new ArrayList<>();
        for (int i = 0; i < to_delete.length; i++) {
            deleteNodes.add(to_delete[i]);
        }
        TreeNode currentNode = root;
        if (root != null) {
            while (!queue.isEmpty() || currentNode != null) {
                if (currentNode != null) {
                    queue.push(currentNode);
                    currentNode = currentNode.left;
                } else {
                    TreeNode node = queue.pop();
                    if (deleteNodes.contains(node.value)) {
                        if (node.left != null) {
                            forest.add(node.left);
                        }

                        if (node.right != null) {
                            forest.add(node.right);
                        }
                    }

                    currentNode = node.right;
                }
            }

            if (root != null) {
                forest.add(root);
            }
        }

        System.out.println("Size : " + forest.size());

        forest.stream().forEach(node -> node.inOrder());

        return forest;
    }


    public static List<TreeNode> delNodesRecursive(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        List<Integer> deleteNodes = new ArrayList<>();
        for (int i = 0; i < to_delete.length; i++) {
            deleteNodes.add(to_delete[i]);
        }

        removeNodes(root, deleteNodes, forest);

        if (!deleteNodes.contains(root.value)) {
            forest.add(root);
        }

        forest.stream().forEach(node -> node.inOrder());

        return forest;
    }

    private static TreeNode removeNodes(TreeNode root, List<Integer> deleteNodes, List<TreeNode> forest) {
        if (root == null) {
            return null;
        }

        root.left = removeNodes(root.left, deleteNodes, forest);
        root.right = removeNodes(root.right, deleteNodes, forest);

        if (deleteNodes.contains(root.value)) {
            if (root.left != null) {
                forest.add(root.left);
            }

            if (root.right != null) {
                forest.add(root.right);
            }

            return null;
        }

        return root;
    }

}
