package com.formation.algomarthon.linkedlist;

/*
/*
# You are given the head of a linked list, and an integer k.
# Return the head of the linked list after swapping the nodes of the kth node from the beginning
and the kth node from the end (the list is 1-indexed).


# Examples
# Input: head = [1,2,3,4,5], k = 2
# Output: [1,4,3,2,5]

head -> 1 -> 2 -> 3 -> 4 -> 5
 */

import com.formation.util.ListNode;

import java.util.List;

public class SwapKthNodeFromLastAndFirst {
    public static void main(String[] args) {
        /*ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(7, null))))));*/
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        System.out.println("Original List : " + head);
        ListNode root = swapKth(head, 1);
        while (root != null) {
            System.out.print(root.value + " ");
            root = root.next;
        }
    }

    private static ListNode swapKth(ListNode root, int k) {
        // Count the number of nodes
        int numOfNodes = 0;
        ListNode currentNode = root;
        while (currentNode != null) {
            numOfNodes++;
            currentNode = currentNode.next;
        }

        // Find the Kth node from First and last
        ListNode prevFirstKthNode = null;
        ListNode prevToLastKthNode = null;

        int lastKthPos = numOfNodes - k + 1; // 5 - 2 = 3 -> 4

        int currentPos = 0;
        currentNode = root;
        while (currentNode != null) {
            currentPos++;
            if (currentPos == k - 1) {
                prevFirstKthNode = currentNode;
            } else if (currentPos == lastKthPos - 1) {
                prevToLastKthNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        if (k > 1) {
            // Swap the nodes; null pointer if k = 1
            ListNode firstKthNode = prevFirstKthNode.next; // this will hold first kth node
            ListNode lastKthNode = prevToLastKthNode.next;

            ListNode nextNodeAfterLastKthNode = lastKthNode.next;

            lastKthNode.next = null;
            prevFirstKthNode.next = lastKthNode;
            lastKthNode.next = firstKthNode.next;
            firstKthNode.next = nextNodeAfterLastKthNode;
            prevToLastKthNode.next = firstKthNode;
        } else {
            ListNode tmp = root.next;
            ListNode firstKthNode = root;
            ListNode lastNode = prevToLastKthNode.next;
            lastNode.next = tmp;
            root = lastNode;
            prevToLastKthNode.next = firstKthNode;
            firstKthNode.next = null;
        }

        //swap the values

        /*int tmp = firstKthNode.value;
        firstKthNode.value = lastKthNode.value;
        lastKthNode.value = tmp;*/

        return root;
    }
}
