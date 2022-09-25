package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

import java.util.List;

public class MergeList {
    public static void main(String[] args) {
        ListNode head = mergeKLists(
                new ListNode[]{
                        new ListNode(1, new ListNode(4, new ListNode(5))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(2, new ListNode(6, new ListNode(7)))});
        System.out.println(head);

        head = divideAndConquer(
                new ListNode[]{
                        new ListNode(1, new ListNode(2, new ListNode(2))),
                        new ListNode(1, new ListNode(1, new ListNode(2)))});
        System.out.println(head);
        head = divideAndConquer(
                new ListNode[]{
                        new ListNode(1, new ListNode(4, new ListNode(5))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(2, new ListNode(6, new ListNode(7)))});
        System.out.println(head);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else {
            ListNode l1 = lists[0];
            for (int i = 1; i < lists.length; i++) {
                ListNode listNode = lists[i];
                ListNode currentNode = l1;
                ListNode prevNode = null;
                while (listNode != null) {
                    ListNode newNode = new ListNode(listNode.value);
                    while (currentNode != null && currentNode.value < listNode.value) {
                        prevNode = currentNode;
                        currentNode = currentNode.next;
                    }

                    //if prevNode and currentNode same, all the values currentNode is greater than listNode
                    if (l1 == currentNode) {
                        newNode.next = l1;
                        currentNode = l1 = newNode;
                        currentNode = currentNode.next;
                    } else if (prevNode != null) {
                        ListNode tmp = prevNode.next;
                        prevNode.next = newNode;
                        prevNode.next.next = tmp;
                        if (currentNode != null) {
                            prevNode = currentNode;
                        } else {
                            prevNode = newNode;
                        }
                    }

                    listNode = listNode.next;

                }
            }

            return l1;
        }
    }

    private static ListNode divideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else {
            int len = lists.length;
            int interval = 1;
            while (interval < len) {
                int range = len - interval;
                for (int i = 0; i < range; i = i + 2) {
                    lists[i] = merge(lists[i], lists[i + interval]);
                }
                interval *= 2;
            }

            return lists[0];
        }
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                currentNode.next = new ListNode(l1.value);
                l1 = l1.next;
            } else {
                currentNode.next = new ListNode(l2.value);
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        while (l1 != null) {
            currentNode.next = new ListNode(l1.value);
            currentNode = currentNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            currentNode.next = new ListNode(l2.value);
            currentNode = currentNode.next;
            l2 = l2.next;
        }
        return head.next;
    }
}
