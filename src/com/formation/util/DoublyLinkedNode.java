package com.formation.util;

public class DoublyLinkedNode {
    public int value;
    public DoublyLinkedNode next;
    public DoublyLinkedNode prev;

    public DoublyLinkedNode(int v, DoublyLinkedNode nextNode, DoublyLinkedNode pNode) {
        value = v;
        next = nextNode;
        prev = pNode;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(value);
        DoublyLinkedNode currentNext = next;
        while (currentNext != null) {
            builder.append(" ").append(currentNext.value);
            currentNext = currentNext.next;
        }
        return builder.toString();
    }
}
