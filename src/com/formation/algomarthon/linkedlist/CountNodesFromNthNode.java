package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

/*
Given a linked list, count the number of nodes from the kth position (from the head) to the end of the list.

You may assume all elements have positive integer value, and k is positive.
k position/index follows the one-based numbering rule (i.e. the position/index of the first element of an array is 1, not 0).
If k exceeds the length of the list, return -1 instead.
Examples:

Given an array: [1, 2, 3], k: 1 // returns 3
Note: k position is 1, so count from the first element of the given linked list to the end of the list.

Given an array: [1, 2, 3], k: 2 // returns 2
Note: k position is 2, so count from the second element of the given linked list to the end of the list.

Given an array: [1, 2, 3], k: 4 // returns -1
Note: k position exceeds the length of the list (= 3), thus return -1.

[execution time limit] 3 seconds (java)

 */
public class CountNodesFromNthNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));

        System.out.println(countNodesFromNthNode(l1, 2));
    }

    private static int countNodesFromNthNode(ListNode head, int k) {
        int totalNodes = 0;
        while (head != null) {
            totalNodes++;
            head = head.next;
        }

        if (k > 0 && totalNodes == 0) {
            return -1;
        }

        return totalNodes - k + 1;
    }
}
