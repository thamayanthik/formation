package com.formation.algoblitz.CodeSignal;

import com.formation.util.ListNode;

public class SwapElementsLinkedList {
    public static void main(String[] args) {
        ListNode head = swapElement(new ListNode(10, new ListNode(20, null)));
        System.out.println(head);
    }

    private static ListNode swapElement(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while (currentNode != null) {
            int temp = currentNode.value;

            if (nextNode != null) {
                currentNode.value = nextNode.value;
                nextNode.value = temp;
                currentNode = nextNode.next;
                if (currentNode != null) {
                    nextNode = currentNode.next;
                }
            } else {
                currentNode = null;
            }
        }

        return head;
    }
}
