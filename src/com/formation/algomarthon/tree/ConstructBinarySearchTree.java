package com.formation.algomarthon.tree;

import com.formation.util.TreeNode;

public class ConstructBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};
        TreeNode root = sortedArrayToBST(arr);
        preOrder(root);
        System.out.println();
        TreeNode head = recursive(arr, 0, arr.length - 1);
        preOrder(head);
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums != null) {
            //Find root index
            int len = nums.length;
            int mid = len / 2;
            if (len % 2 == 0) {
                mid--;
            }
            root = new TreeNode(nums[mid], null, null);
            TreeNode currentNode = root;
            //construct left tree
            int i = 0;
            while (i < len) {
                if (i != mid) {
                    TreeNode preNode = null;
                    while (currentNode != null) {
                        preNode = currentNode;
                        if (nums[i] < currentNode.value) {
                            currentNode = currentNode.left;
                        } else {
                            currentNode = currentNode.right;
                        }
                    }
                    if (nums[i] < preNode.value) {
                        preNode.left = new TreeNode(nums[i], null, null);
                    } else {
                        preNode.right = new TreeNode(nums[i], null, null);
                    }
                    currentNode = preNode;
                } else {
                    currentNode = root;
                }
                i++;
            }
        }

        return root;
    }

    private static TreeNode recursive(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(arr[mid], null, null);

        node.left = recursive(arr, start, mid - 1);

        node.right = recursive(arr, mid + 1, end);

        return node;
    }
}
