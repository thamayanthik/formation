package com.formation.algoblitz.linkedlist;

import com.formation.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkListToArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertListToArray(new ListNode(10, new ListNode(3, null)))));
    }

    private static int[] convertListToArray(ListNode head) {
        List<Integer> e = new ArrayList<>();
        while (head != null) {
            e.add(head.value);
            head =  head.next;
        }

        int[] r = new int[e.size()];
        for (int i = 0; i < e.size(); i++) {
            r[i] = e.get(i);
        }

        int low = 0;
        int high = r.length - 1;

        while (low < high) {
            int tmp = r[low];
            r[low] = r[high];
            r[high] = tmp;
            low++;
            high--;
        }

        return r;
    }
}
