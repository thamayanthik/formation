package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

public class FindElement {
    public static void main(String[] args) {

        boolean elementExists = findElement(NodeCreationHelper.createNode(8), 2);

        System.out.println("Result : " + elementExists);
    }

    private static boolean findElement(ListNode node, int target) {

        while (node != null) {
            if (node.value == target) {
                return true;
            }
            node = node.next;
        }

        return false;
    }
}
