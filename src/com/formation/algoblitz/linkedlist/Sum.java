package com.formation.algoblitz.linkedlist;

import java.util.LinkedList;

public class Sum {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(10);
        l.add(30);

        int total = sumOfAllValues(l);
        System.out.println(total);
    }

    private static int sumOfAllValues(LinkedList input) {
        int sum = 0;
        LinkedList head = input;

        while (!head.isEmpty()) {
            sum += (Integer) head.poll();
        }

        return sum;
    }

}
