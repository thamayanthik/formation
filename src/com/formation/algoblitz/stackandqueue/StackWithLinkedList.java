package com.formation.algoblitz.stackandqueue;

import com.formation.util.ListNode;

class Stack {
    LLNode head;
    LLNode currentNode;

    private static int count = 0;

    public int pop() {
        if (currentNode != null) {
            count--;
            int value = currentNode.value;
            currentNode = currentNode.prev;
            return value;
        }

        return 0;
    }

    public void push(int value) {
        if (head == null) {
            head = new LLNode(value, null, null);
            currentNode = head;
        } else {
            LLNode tmp = currentNode;
            currentNode.next = new LLNode(value, null, null);
            currentNode = currentNode.next;
            currentNode.prev = tmp;
        }
        count++;
    }

    public int size() {
        return count;
    }
}

public class StackWithLinkedList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        System.out.println(s.size());
        s.push(20);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
    }
}
