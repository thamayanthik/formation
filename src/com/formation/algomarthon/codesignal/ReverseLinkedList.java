package com.formation.algomarthon.codesignal;

import com.formation.util.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = reverseLinkedList(new ListNode(10, new ListNode(20, null)));
        System.out.println(head);
        ListNode head1 = recursion(new ListNode(10, new ListNode(20, null)), null);
        System.out.println(head1);
    }

    private static ListNode reverseLinkedList(ListNode listNode) {
        ListNode currentNode = listNode;
        ListNode prevNode = null;
        while (currentNode != null) {
            ListNode tmp = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = tmp;
        }

        return prevNode;
    }

    private static ListNode recursion(ListNode currentNode, ListNode prevNode) {
        if (currentNode == null) {
            return prevNode;
        }
        ListNode tmp = currentNode.next;
        currentNode.next = prevNode;
        prevNode = currentNode;
        currentNode = tmp;

        return recursion(currentNode, prevNode);
    }
}
