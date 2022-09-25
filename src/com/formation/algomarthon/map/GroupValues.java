package com.formation.algomarthon.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GroupValues {
    public static void main(String[] args) {
        /*System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2}));
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));*/
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            count.put(deck[i], count.getOrDefault(deck[i], 0) + 1);
        }
        int minCount = count.values().stream().min(Comparator.comparing(Integer::valueOf)).get();
        int maxCount = count.values().stream().max(Comparator.comparing(Integer::valueOf)).get();
        int groupSize = 0;
        if (maxCount % minCount == 0) {
            groupSize = minCount;
        } else {
            int i = 2;
            while (i < minCount) {
                if (minCount % i == 0 && maxCount % i == 0) {
                    groupSize = i;
                }
                i++;
            }
        }
        System.out.println("GroupSize : " + groupSize);

        final int mCount = groupSize;
        long oddCount = count.entrySet().stream()
                .filter(e -> mCount == 0 || e.getValue() % mCount != 0 || e.getValue() < 2)
                .count();

        if (oddCount > 0) {
            return false;
        }

        return true;
    }
}
