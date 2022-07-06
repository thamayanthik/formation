package com.formation.algoblitz.linkedlist;

public class InsertTargetElement {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(10, null)));
        Node node = insertTargetElement(head, 11);
    }

    private static Node insertTargetElement(Node head, int target) {
        Node currentNode = head;
        Node prevNode = null;
        if (currentNode == null) {
            Node newNode = new Node(target, null);
            head = newNode;
            return head;
        }

        while (currentNode != null) {
            if (currentNode.value > target) {
                Node newNode = new Node(target, currentNode);
                if (prevNode != null) {
                    prevNode.next = newNode;
                }
                break;
            } else if (currentNode.next == null) {
                Node newNode = new Node(target, null);
                currentNode.next = newNode;
                break;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
