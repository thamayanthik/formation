package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

import java.util.List;

public class InsertZeroAfterEveryNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, null));
        ListNode node = insertNodeWithZero(head);
        System.out.println(node);
    }

    private static ListNode insertNodeWithZero(ListNode head) {
        ListNode currentNode = head;

        while(currentNode != null) {
            ListNode newNode = new ListNode(0, null);
            ListNode nextNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = nextNode;
            currentNode = nextNode;
        }

        return head;
    }
}
