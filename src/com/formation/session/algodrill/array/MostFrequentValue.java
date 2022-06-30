package com.formation.session.algodrill.array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentValue {
    public static void main(String... str) {
        int[] a = {1,2,3,4,1,2,4,5};
        mostFrequentValue(a);
    }

    public static void mostFrequentValue(int[] a) {
        int max = Integer.MIN_VALUE;
        int ans = -1;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int currentCount = 1;
            if (count.containsKey(a[i])) {
                currentCount += count.get(a[i]);
            }

            count.put(a[i], currentCount);
            if (currentCount > max) {
                ans = a[i];
                max = currentCount;
            }
        }

        System.out.println("MostFrequent Element In Array : " + ans);
    }
}
