package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

public class ArrayToLinkedList {
    public static void main(String[] args) {
        System.out.println(convertArrayToLinkList(new int[]{1, 2}).toString());
        System.out.println(convertArrayToLinkList(new int[]{}));
        System.out.println(convertArrayToLinkList(new int[]{1}).toString());
        System.out.println(convertArrayToLinkList(new int[]{1, 2, 3, 4, 5}).toString());
    }

    private static ListNode convertArrayToLinkList(int[] arr) {
        ListNode dummy = new ListNode(0, null);

        ListNode currentNode = dummy;
        for (int i = 0; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i], null);
            currentNode = currentNode.next;
        }

        return dummy.next;
    }
}
