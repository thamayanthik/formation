package com.formation.session.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastFrequentValue {
    public static void main(String... str) {
        int[] a = {1,2, 5,4,1,2,4,3};
        leastFrequentValue(a);
    }

    private static void leastFrequentValue(int[] a) {
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer> count = new HashMap<>();
        //List will store all the least frequent element. In the list first element always first occurrence as list is ordered by default
        List<Integer> minValue = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int currentCount = 1;
            if (count.containsKey(a[i])) {
                currentCount += count.get(a[i]);
            }

            count.put(a[i], currentCount);
            if (currentCount <= min) {
                minValue.add(a[i]);
                min = currentCount;
            } else if (minValue.contains(a[i])) {
                // if the frequency count greater than min, remove the element from minValue list
                minValue.remove(minValue.indexOf(a[i]));
            }
        }

        System.out.println("LeastFrequent Element In Array : " + minValue.get(0));
    }
}
