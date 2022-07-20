package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

public class CreateLinkedList {
    public static void main(String[] args) {
        ListNode head = createLinkList(5, 4);
        System.out.println(head.toString());
    }

    private static ListNode createLinkList(int nodeCount, int nodeVal) {
        ListNode dummy = new ListNode(0, null);

        ListNode currentNode = dummy;
        while (nodeCount > 0) {
            currentNode.next = new ListNode(nodeVal, null);
            currentNode = currentNode.next;
            nodeCount--;
        }

        return dummy.next;
    }
}
