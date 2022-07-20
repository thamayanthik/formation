package com.formation.algoblitz.stackandqueue;

class QLinkedList {
    LLNode head;
    LLNode currentNode;

    private static int nodeSize = 0;

    public void enQueue(int value) {
        nodeSize++;
        if (head == null) {
            head = new LLNode(value, null, null);
            currentNode = head;
        } else {
            currentNode.next = new LLNode(value, null, currentNode);
            currentNode = currentNode.next;
        }
    }

    public int deQueue() {
        if (head != null) {
            nodeSize--;
            int value = head.value;
            head = head.next;
            return value;
        }

        return 0;
    }

    public int size() {
        return nodeSize;
    }

}

class LLNode {
    int value;
    LLNode next;
    LLNode prev;

    public LLNode(int v, LLNode next, LLNode prev) {
        value = v;
        this.next = next;
        this.prev = prev;
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        QLinkedList qLinkedList = new QLinkedList();
        qLinkedList.enQueue(10);
        qLinkedList.enQueue(20);
        System.out.println(qLinkedList.size());
        System.out.println(qLinkedList.deQueue());
        System.out.println(qLinkedList.deQueue());
        System.out.println(qLinkedList.size());
    }


}
