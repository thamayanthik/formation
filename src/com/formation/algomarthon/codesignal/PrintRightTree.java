package com.formation.algomarthon.codesignal;

import com.formation.util.TreeNode;

import java.util.*;

public class PrintRightTree {
    public static void main(String[] args) {
        TreeNode tl1 = new TreeNode(8, null, null);

        TreeNode sl1 = new TreeNode(4, null, null);
        TreeNode sl2 = new TreeNode(6, null, null);

        TreeNode sr1 = new TreeNode(5, null, null);
        TreeNode sr2 = new TreeNode(7, null, null);

        TreeNode fl = new TreeNode(2, sl1, null);
        TreeNode fr = new TreeNode(3, null, null);
        TreeNode head = new TreeNode(1, fl, fr);

        printRightView(head);

        Map<String, Integer> levelTrack = new HashMap<>();
        levelTrack.put("maxLevel", -1);

        System.out.println(getRightViewValues(head, 0, levelTrack, new ArrayList<>()));
    }

    private static void printRightView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> values = new ArrayList<>();
        if (root != null) {
            queue.add(root);
            // Get The Highest Level of right tree
            int rightHighLevel = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                rightHighLevel++;
                values.add(queue.peek().value);
                while (size > 0) {
                    TreeNode currentNode = queue.poll();

                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    size--;
                }
            }

            if (root.left != null) {
                queue.add(root.left);
            }

            int leftLevel = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                leftLevel++;
                if (leftLevel >= rightHighLevel) {
                    values.add(queue.peek().value);
                }
                while (size > 0) {
                    TreeNode currentNode = queue.poll();
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }

                    size--;
                }
            }

            System.out.println("values : " + values);
        }
    }

    /*               1
     *             /   \
     *            2     3
     *           /
     *          4
     *
     * root -> result = {1}, maxLevel = 0, Level = 0
     *       -> node (3) => result = {1,3}, maxLevel = 1, level = 2, right call return null
     *    node(2), 1, 1, {1,3}, no right node
     *    node(4), 2, 1, {1,3} -> {1,3,4} -> level 3, maxLevel = 2,
     */
    private static List<Integer> getRightViewValues(TreeNode root, int level, Map<String, Integer> maxLevel, List<Integer> result) {
        if (root == null) {
            return null;
        }
        if (maxLevel.get("maxLevel") < level) {
            result.add(root.value);
            maxLevel.put("maxLevel", level);
        }

        getRightViewValues(root.right, level + 1, maxLevel, result);
        getRightViewValues(root.left, level + 1, maxLevel, result);

        return result;
    }
}
