package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

/*
Given a linked list, remove the center node.
If the length of the list is even, remove the first of the two center nodes.

For example, given this list:
1 -> 2 -> 3 -> 4

Return:
1 -> 3 -> 4

 */
public class RemoveMidNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        removeMidNode(head);
        head = new ListNode(1, new ListNode(3, new ListNode(5, null)));
        removeMidNode(head);
        head = new ListNode(1, new ListNode(3, null));
        removeMidNode(head);
    }

    private static ListNode removeMidNode(ListNode head) {
        if (head != null) {
            System.out.println("Input : " + head.toString());
            ListNode slow = head;
            ListNode fast = head.next;
            ListNode prevNode = head;
            int count = 1;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prevNode = slow;
                count += 2;
                slow = slow.next;
            }

            if (fast != null) {
                count++;
            }
            // 1 -> 2 -> 3- > 4
            System.out.println("Linked List Size : " + count);
            if (count > 2) {
                /*if (count % 2 == 0) {
                    prevNode = prevNode.next;
                    slow = slow.next;
                }*/
                prevNode.next = slow.next;
            } else {
                head.next = null;
            }

            System.out.println("Output : " + head.toString());
        }

        return head;
    }
}
