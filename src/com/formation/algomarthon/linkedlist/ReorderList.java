package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
       // ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode root = new ListNode(1);
        List<ListNode> splitNodes = spiltListNodes(root);
        ListNode secondList = splitNodes.get(1);

        ListNode updatedNode = null;

        if (secondList != null) {
            updatedNode = reverseListNode(secondList, null);
        }

        System.out.println("updatedNode : " + updatedNode);

        ListNode reversedList = splitNodes.get(0);
        ListNode currentNode = reversedList;
        ListNode prevNode = reversedList;

        while (currentNode != null && updatedNode != null) {
            ListNode tmp = currentNode.next;
            ListNode insertNode = new ListNode(updatedNode.value);
            currentNode.next = insertNode;
            insertNode.next = tmp;
            prevNode = insertNode;
            currentNode = insertNode.next;
            updatedNode = updatedNode.next;
        }

        if (updatedNode != null) {
            prevNode.next = updatedNode;
        }

        System.out.println("reversedList : " + reversedList);
    }

    private static ListNode reverseListNode(ListNode currentNode, ListNode prev) {
        if (currentNode == null) {
            return prev;
        }

        ListNode nextNode = currentNode.next;
        currentNode.next = prev;
        prev = currentNode;
        currentNode = nextNode;
        return reverseListNode(currentNode, prev);
    }

    private static List<ListNode> spiltListNodes(ListNode root) {
        ListNode fast = root;
        ListNode slow = root;
        ListNode prev = root;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        List<ListNode> res = new ArrayList<>();

        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;

        while (slow != root && slow != null) {
            currentNode.next = new ListNode(slow.value);
            currentNode = currentNode.next;
            slow = slow.next;
        }

        prev.next = null;

        res.add(root);
        res.add(dummy.next);

        System.out.println("After Split: " + res);

        return res;
    }
}
