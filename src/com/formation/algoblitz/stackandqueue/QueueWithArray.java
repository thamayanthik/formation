package com.formation.algoblitz.stackandqueue;

class Queue {
    int[] values;
    private static int pos = 0;
    private static int dequeuePos = 0;

    public Queue(int cap) {
        values = new int[cap];
    }

    public void enqueue(int value) {
        if (pos < values.length) {
            values[pos++] = value;
        }
    }

    public int dequeue() {
        if (dequeuePos >= 0) {
            return values[dequeuePos++];
        }
        return 0;
    }

    public int size() {
        return pos-dequeuePos;
    }
}
public class QueueWithArray {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Size : " + queue.size());
        queue.dequeue();
        queue.dequeue();
        System.out.println("Size : " + queue.size());
    }
}
