package com.formation.algobits;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ValueMatchCount {
    public static void main(String... str) {
        int[] array = {1,2,3};
        int k = 1;

        System.out.println(match(array, k));

    }

    private static boolean match(int[] array, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i< array.length; i++) {
            int currentCount = 1;
            if (countMap.containsKey(array[i])) {
                currentCount += countMap.get(array[i]);
            }

            if (currentCount == k) {
                return true;
            }

            countMap.put(array[i], currentCount);
        }
        Optional<Integer> matchingValue = countMap.keySet().stream().filter(key -> countMap.get(key) == k).findFirst();

        if (matchingValue.isPresent()) {
            return true;
        }

        return  false;
    }
}
