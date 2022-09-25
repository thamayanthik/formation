package com.formation.algomarthon.recursion;

import com.formation.util.TreeNode;

public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode sl1 = new TreeNode(4, null, null);

        TreeNode fl = new TreeNode(2, null, sl1);
        TreeNode fr = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, fl, fr);

        System.out.println(convertTreeToStringUsingPreOrder(root, new StringBuilder()));
    }

    private static String convertTreeToStringUsingPreOrder(TreeNode root, StringBuilder strBuilder) {
        if (root != null) {
            strBuilder.append(root.value);
            if (root.left != null) {
                strBuilder.append('(');
                convertTreeToStringUsingPreOrder(root.left, strBuilder);
                strBuilder.append(')');
            } else if (root.right != null) {
                strBuilder.append('(');
                strBuilder.append(')');
            }
            if (root.right != null) {
                strBuilder.append('(');
                convertTreeToStringUsingPreOrder(root.right, strBuilder);
                strBuilder.append(')');
            }
        }

        return strBuilder.toString();

    }
}
