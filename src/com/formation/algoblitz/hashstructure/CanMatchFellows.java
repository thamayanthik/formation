package com.formation.algoblitz.hashstructure;

import java.util.*;
import java.util.stream.Collectors;

public class CanMatchFellows {
    public static void main(String... str) {
        System.out.println("Matching Pair Exists : " + canMatchFellows(Map.of("oliver", 5, "pixel", 3, "pinky", 5, "tobey",5)));

        System.out.println("Matching Pair Exists : " + solution2(Map.of("oliver", 5, "pixel", 3, "pinky", 5, "tobey",5)));
    }

    private static boolean canMatchFellows(Map<String, Integer> input) {
        Map<Integer, Integer> skillMatchCount = new HashMap<>();
        boolean pairExists = true;
        List<Integer> skillLevel = input.values().stream().collect(Collectors.toList());
        for (Integer s : skillLevel) {
            int currentCount = 1;
            if (skillMatchCount.containsKey(s)) {
                currentCount += skillMatchCount.get(s);
            }

            skillMatchCount.put(s, currentCount);
        }

        List<Integer> match = skillMatchCount.values().stream().collect(Collectors.toList());
        for (Integer m : match) {
            if (m % 2 != 0) {
             return false;
            }
        }

        return true;
    }

    private static boolean solution2(Map<String, Integer> input) {
        Set<Integer> pair = new HashSet<>();
        List<Integer> skillLevel = input.values().stream().collect(Collectors.toList());
        for (Integer s : skillLevel) {
            if (pair.contains(s)) {
                pair.remove(s);
            } else {
                pair.add(s);
            }
        }

        return pair.isEmpty();
    }
}
