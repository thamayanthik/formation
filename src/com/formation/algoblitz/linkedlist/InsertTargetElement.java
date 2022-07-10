package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

public class InsertTargetElement {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(10, null)));
        ListNode node = insertTargetElement(head, 11);
    }

    private static ListNode insertTargetElement(ListNode head, int target) {
        ListNode currentNode = head;
        ListNode prevNode = null;
        if (currentNode == null) {
            ListNode newNode = new ListNode(target, null);
            head = newNode;
            return head;
        }

        while (currentNode != null) {
            if (currentNode.value > target) {
                ListNode newNode = new ListNode(target, currentNode);
                if (prevNode != null) {
                    prevNode.next = newNode;
                }
                break;
            } else if (currentNode.next == null) {
                ListNode newNode = new ListNode(target, null);
                currentNode.next = newNode;
                break;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
