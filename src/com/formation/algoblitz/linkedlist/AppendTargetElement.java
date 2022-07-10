package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

public class AppendTargetElement {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(10, null)));
        ListNode node = appendTargetElement(head, 11);

        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }

        System.out.println();

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(10, null)));
        ListNode node1 = appendElementUsingRecursion(head1, head1, 11);

        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }

        System.out.println();

        node1 = appendElementUsingRecursion(null, null, 11);
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }
    }

    private static ListNode appendTargetElement(ListNode head, int target) {
        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        ListNode node = new ListNode(target, null);

        if (currentNode == null) {
            head = node;
        } else {
            currentNode.next = node;
        }

        return head;
    }

    private static ListNode appendElementUsingRecursion(ListNode head, ListNode currentNode, int target) {
        if (currentNode == null || (currentNode != null && currentNode.next == null)) {
            ListNode node = new ListNode(target, null);
            if (currentNode != null) {
                currentNode.next = node;
            } else {
                head = node;
            }
            return head;
        } else {
            return appendElementUsingRecursion(head, currentNode.next, target);
        }
    }
}
