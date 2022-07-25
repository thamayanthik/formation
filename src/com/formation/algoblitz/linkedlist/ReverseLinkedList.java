package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;



public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(4, null));
        System.out.println(reverseList(head).toString());
        head = new ListNode(5, new ListNode(4, null));
        System.out.println(recursiveReverseLinkedList(head, null).toString());
    }

    private static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = preNode;
            preNode = head;
            head = tmp;
        }

        return preNode;
    }

    private static ListNode recursiveReverseLinkedList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        } else {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            return recursiveReverseLinkedList(head, prev);
        }
    }
}
