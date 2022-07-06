package com.formation.algoblitz.linkedlist;

import java.util.Random;

public class NodeCreationHelper {

    public static Node createNode(int numberOfNodes) {
        Node dummyHead = new Node(0, null);

        Random r = new Random();
        Node prevNode = null;
        System.out.print("Node : ");
        while (numberOfNodes > 0) {
            int value = r.nextInt(1, 10);
            System.out.print(value + " ");
            Node currentNode = new Node(value, null);

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
