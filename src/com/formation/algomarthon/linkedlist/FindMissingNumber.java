package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(null));
        System.out.println(findMissingNumber(new ListNode(1, null)));
        System.out.println(findMissingNumber(new ListNode(1, new ListNode(3, null))));
        ListNode head = new ListNode(1, new ListNode(3, null));

        System.out.println(findMissingRecursive(head.next, head.value));
    }

    private static int findMissingNumber(ListNode head) {
        if (head != null) {
            int ln = head.value;
            ListNode currentNode = head.next;
            while (currentNode != null) {
                if (Math.abs(currentNode.value) - Math.abs(ln) != 1) {
                    return ++ln;
                }
                ln = currentNode.value;
                currentNode = currentNode.next;
            }

            return ++ln;
        }

        return 1;
    }

    private static int findMissingRecursive(ListNode head, int ln) {
        if (head == null) {
            return ++ln;
        }

        if (Math.abs(head.value) - Math.abs(ln) != 1) {
            return ++ln;
        }

        return findMissingRecursive(head.next, head.value);
    }
}
