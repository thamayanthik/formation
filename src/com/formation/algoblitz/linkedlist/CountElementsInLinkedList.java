package com.formation.algoblitz.linkedlist;

import java.util.LinkedList;

public class CountElementsInLinkedList {
    public static void main(String[] args) {

        int numberOfElements = countElementsUsingRecursion(NodeCreationHelper.createNode(8));

        System.out.println("Result : " + numberOfElements);
    }

    private static int countElementsUsingIteration(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    private static int countElementsUsingRecursion(Node head) {

       if (head == null) {
           return 0;
       }

       return 1 + countElementsUsingRecursion(head.next);
    }
}
