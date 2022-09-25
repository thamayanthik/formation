package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

public class SwapTwoNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode res = swapNodes(head);
        System.out.println(res.toString());
    }

    private static ListNode swapNodes(ListNode root) {
        ListNode currentNode = root;
        ListNode newHead = null, prevNode = null, p1 = null;
        while (currentNode != null) {
            if (prevNode != null) {
                ListNode tmp = currentNode.next;
                if (p1 != null) {
                    p1.next = currentNode;
                }

                currentNode.next = prevNode;
                if (newHead == null) {
                    newHead = currentNode;
                }
                p1 = prevNode;
                prevNode.next = tmp;
                prevNode = tmp;
                if (tmp != null) {
                    currentNode = tmp.next;
                } else {
                    currentNode = null;
                }
             } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

        }

        if (newHead == null) {
            newHead = root;
        }

        return newHead;
    }
}
