package com.formation.algomarthon.codesignal;

import com.formation.util.ListNode;

public class ReverseLinkedListOfKElement {
    public static void main(String[] args) {
        ListNode root = new ListNode(10, null);
        root.next =  new ListNode(20, new ListNode(30, new ListNode(40, null)));
        ListNode head1 = reverseKPosition(root, 2);
        System.out.println(head1);
    }

    private static ListNode reverseKPosition(ListNode root, int k) {
        ListNode currentNode = root;
        ListNode prevNode = null;
        ListNode reverseList = null;
        int nodeCount = 0;
        while (currentNode != null) {
            if (nodeCount == k) {
                if (reverseList == null) {
                    reverseList = prevNode;
                } else {
                    ListNode currentReverseList = reverseList;
                    while (currentReverseList.next != null) {
                        currentReverseList = currentReverseList.next;
                    }
                    currentReverseList.next = prevNode;
                }
                nodeCount = 0;
                prevNode = null;
            }

            ListNode tmp = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = tmp;

            nodeCount++;
        }

        if (prevNode != null) {
            ListNode currentReverseList = reverseList;
            while (currentReverseList.next != null) {
                currentReverseList = currentReverseList.next;
            }
            currentReverseList.next = prevNode;
        }

        return reverseList;
    }
}
