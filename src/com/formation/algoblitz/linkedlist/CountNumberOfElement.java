package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

public class CountNumberOfElement {
    public static void main(String[] args) {
        System.out.println("Number Of Elements : " + countNumberOfElements(NodeCreationHelper.createNode(10)));
        System.out.println("Number Of Elements : " + countNumberOfElements(null));
    }

    private static int countNumberOfElements(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }

        return count;
    }

}
