package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

interface Mapper<T, R> {
    R apply(T value);
}
public class StreamMapImplementation {
    public static void main(String[] args) {
        Mapper<ListNode, ListNode> m = (n) -> new ListNode(n.value * 2, null);

        ListNode head = new ListNode(3, new ListNode(4, null));

        System.out.println("Input Nodes " + head);

        ListNode newHead = map(head, m);

        System.out.println("Output Nodes " + newHead);
    }

    private static ListNode map(ListNode head, Mapper<ListNode, ListNode> m) {
        ListNode newHead = new ListNode(0, null);
        ListNode currentNode = newHead;
        while (head != null) {
            currentNode.next = m.apply(head);
            head = head.next;
            currentNode = currentNode.next;
        }

        return newHead.next;
    }
}
