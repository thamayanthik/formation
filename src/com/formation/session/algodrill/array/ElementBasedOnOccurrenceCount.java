package com.formation.session.algodrill.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Description: Number of elements with exactly 2 occurrences ([1, 2, 1, 3, 2, 4] returns 2)
 */
public class ElementBasedOnOccurrenceCount {
    public static void main(String... str) {
        int[] a = {1,2, 5,4,1,2,4,3};
        int k = 2;
        occurrenceCount(a, k);
    }

    private static void occurrenceCount(int[] a, int k) {
        Map<Integer, Integer> occurrenceCount = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < a.length;i++) {
            int currentCount = 1;
            if (occurrenceCount.containsKey(a[i])) {
                currentCount += occurrenceCount.get(a[i]);
            }

            occurrenceCount.put(a[i], currentCount);

            if (currentCount == k) {
                answer.add(a[i]);
            } else if (currentCount > k && answer.contains(a[i])) {
                answer.remove(answer.indexOf(a[i])); // Inside this might take O(n)
            }
        }

        System.out.println("Resulting Element : " + answer);
    }


}
