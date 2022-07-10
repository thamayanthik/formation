package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

import java.util.Random;

public class NodeCreationHelper {

    public static ListNode createNode(int numberOfNodes) {
        ListNode dummyHead = new ListNode(0, null);

        Random r = new Random();
        ListNode prevNode = null;
        System.out.print("Node : ");
        while (numberOfNodes > 0) {
            int value = r.nextInt(1, 10);
            System.out.print(value + " ");
            ListNode currentNode = new ListNode(value, null);

            if (prevNode == null) {
                dummyHead.next = currentNode;
            } else {
                prevNode.next = currentNode;
            }

            prevNode = currentNode;

            numberOfNodes--;
        }

        System.out.println();

        return dummyHead.next;
    }
}
