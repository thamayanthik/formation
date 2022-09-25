package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

public class ReturnSecondLast {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(5, null)));
        System.out.println(getSecondLast(head));
    }

    private static int getSecondLast(ListNode head) {
        if (head.next.next == null) {
            return head.value;
        }

        return getSecondLast(head.next);
    }
}
