package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfOccurrence {

    public static void main(String[] args) {
        long numberOccurred2 = numberOfOccurrence(NodeCreationHelper.createNode(8));

        System.out.println("Result : " + numberOccurred2);
    }

    private static long numberOfOccurrence(ListNode node) {
        Map<Integer, Integer> count = new HashMap<>();

        while (node != null) {
            count.put(node.value, count.getOrDefault(node.value, 0) + 1);
            node = node.next;
        }

        return count.entrySet().stream().filter(e -> e.getValue() == 2).count();

    }
}
