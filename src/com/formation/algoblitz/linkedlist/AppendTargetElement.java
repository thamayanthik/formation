package com.formation.algoblitz.linkedlist;

public class AppendTargetElement {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(10, null)));
        Node node = appendTargetElement(head, 11);

        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }

        System.out.println();

        Node head1 = new Node(1, new Node(2, new Node(10, null)));
        Node node1 = appendElementUsingRecursion(head1, head1, 11);

        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }

        System.out.println();

        node1 = appendElementUsingRecursion(null, null, 11);
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }
    }

    private static Node appendTargetElement(Node head, int target) {
        Node currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        Node node = new Node(target, null);

        if (currentNode == null) {
            head = node;
        } else {
            currentNode.next = node;
        }

        return head;
    }

    private static Node appendElementUsingRecursion(Node head, Node currentNode, int target) {
        if (currentNode == null || (currentNode != null && currentNode.next == null)) {
            Node node = new Node(target, null);
            if (currentNode != null) {
                currentNode.next = node;
            } else {
                head = node;
            }
            return head;
        } else {
            return appendElementUsingRecursion(head, currentNode.next, target);
        }
    }
}
