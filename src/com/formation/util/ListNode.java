package com.formation.util;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int v, ListNode nextNode) {
        value = v;
        next = nextNode;
    }

    public ListNode(int v) {
        value = v;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(value);
        ListNode currentNext = next;
        while (currentNext != null) {
            builder.append(" ").append(currentNext.value);
            currentNext = currentNext.next;
        }
        return builder.toString();
    }
}
