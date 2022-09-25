package com.formation.algomarthon.linkedlist;

import com.formation.util.ListNode;

/*
Given a linked list and a sorted array of ints, remove all nodes at the indices found in the array.
Any indices that are past the end of the linked list should be ignored.

Note that the indices refer to the indices before any nodes are removed.

Example #1. Given the array [0, 2] and the linked list:
1 -> 3 -> 5 -> 2

We would remove the nodes at indices 0 and 2. Therefore, we would return:
3 -> 2

Example #2. Given the array [1, 3, 4] and the linked list:
1 -> 3 -> 5 -> 2

We would remove the nodes at indices 1, 3 and 4. Since 4 is past the end of the list,
we would only remove the nodes at indices 1 and 3. Therefore, we would return:
1 -> 5
 */
public class RemoveNodeByIndices {
    public static void main(String[] args) {

    }

   private static ListNode removeNodes(ListNode list, int[] indices) {
        if (indices.length > 0) {
            ListNode currentNode = list;
            ListNode prevNode = null;
            int index = 0, count = 0;
            while (currentNode != null) {
                if (index < indices.length && count == indices[index]) {
                    index++;
                    ListNode tmp = currentNode.next;
                    if (prevNode != null) {
                        prevNode.next = tmp;
                    } else if (currentNode == list) {
                        list = tmp;
                    }
                    currentNode = tmp;
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }

                count++;
            }
        }

        return list;
    }
}
