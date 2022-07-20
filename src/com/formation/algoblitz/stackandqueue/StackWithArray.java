package com.formation.algoblitz.stackandqueue;

import java.util.Arrays;

class Stack1 {
    int[] values;
    int pos = 0;

    public Stack1(int cap) {
        values = new int[cap];
    }

    public void push(int value) {
        if (pos > values.length / 2) {
            int[] tmp = new int[values.length * 2];
            for (int i = 0; i < pos;i++) {
                tmp[i] = values[i];
            }

            values = tmp;
        }

        values[pos++] = value;

        System.out.println(Arrays.toString(values));
    }

    public int pop() {
        if (pos > 0) {
            int v = values[--pos];
            return v;
        }

        return 0;
    }

    public int size() {
        return pos;
    }
}

public class StackWithArray {
    public static void main(String[] args) {
        Stack1 s = new Stack1(1);
        s.push(10);
        s.push(20);
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());
    }
}
