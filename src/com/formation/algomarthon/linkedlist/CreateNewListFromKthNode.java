package com.formation.algomarthon.linkedlist;

/*
Given a linked list, make a copy of the list from the kth position (from the head) to the end of the list.

You may assume all elements have positive integer value, and k is positive.
k position/index follows the one-based numbering rule
(i.e. the position/index of the first element of an array is 1, not 0).
If k exceeds the length of the list, return a linked list node with a value -1 instead.
Examples:

Given an array: [1, 2, 3], k: 1 // returns [1, 2, 3]
Note: k position is 1, so copy from the first element of the given linked list to the end of the list.

Given an array: [1, 2, 3], k: 2 // returns [2, 3]
Note: k position is 2, so copy from the second element of the given linked list to the end of the list.

Given an array: [1, 2, 3], k: 4 // returns [-1]
Note: k position exceeds the length of the list (= 3), thus return a node with -1 value.
 */

import com.formation.util.ListNode;

public class CreateNewListFromKthNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode res = createNewListFromKthNode(l1, 2);
        System.out.println(res.toString());
    }

    private static ListNode createNewListFromKthNode(ListNode head, int k) {
        int nodeCountSoFar = 0;

        while (head != null) {
            nodeCountSoFar++;
            if (nodeCountSoFar >= k) {
                return head;
            }
            head = head.next;
        }

        return new ListNode(-1);
    }
}
