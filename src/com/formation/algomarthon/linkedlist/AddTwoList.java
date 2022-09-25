package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

public class AddTwoList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode result = addTwoList(l1, l2);
        System.out.println(result);

        l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        result = addTwoListRecursive(l1, l2);
        System.out.println(result);
    }

    /*
        Iterative approach
     */
    private static ListNode addTwoList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode currentNode = l1;
        ListNode prevNode = null;

        int q = 0;
        while (currentNode != null || l2 != null) {
            int sum = currentNode.value + q;
            if (l2 != null) {
                sum += l2.value;
            }
            if (sum > 9) {
                q = sum / 10;
                sum %= 10;
            } else {
                q = 0;
            }

            currentNode.value = sum;
            prevNode = currentNode;
            if (currentNode.next == null && l2 != null && l2.next != null) {
                currentNode.next = l2.next;
                l2 = null;
            }
            currentNode = currentNode.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (q > 0) {
            prevNode.next = new ListNode(q, null);
        }

        return l1;
    }

    private static ListNode addTwoListRecursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode currentNode = l1;
        mergeList(currentNode, l2, 0);
        return l1;
    }

    private static void mergeList(ListNode l1, ListNode l2, int q) {
        if (l1 != null) {
            int sum = l1.value + q;
            if (l2 != null) {
                sum += l2.value;
            }

            if (sum > 9) {
                q = sum / 10;
                sum %= 10;
            } else {
                q = 0;
            }

            l1.value = sum;
            if (l1.next == null && l2.next != null) {
                l1.next = l2;
                l2.next = null;
            } else if (l1.next == null && q > 0) {
                l1.next = new ListNode(q, null);
            }

            mergeList(l1.next, l2 != null ? l2.next : null, q);
        }

    }
}
