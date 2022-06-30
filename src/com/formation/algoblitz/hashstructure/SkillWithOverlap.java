package com.formation.algoblitz.hashstructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SkillWithOverlap {
    public static void main(String... str) {
        printHighestSkillLevel(Map.of("oliver", 3, "pixel", 1, "pinky", 3));

        printHighestSkillLevel(Map.of("oliver", 3, "pixel", 1, "pinky", 3, "tobey", 1));
    }

    private static void printHighestSkillLevel(Map<String, Integer> input) {
        Iterator<Map.Entry<String, Integer>> itr = input.entrySet().iterator();
        Map<Integer, Integer> skillRating = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int skill = -1;
        while (itr.hasNext()) {
            Map.Entry<String, Integer> pair = itr.next();
            int currentRanting = skillRating.getOrDefault(pair.getValue(), 0) + 1;
            if (max < currentRanting) {
                skill = pair.getValue();
                max = currentRanting;
            }
        }

        System.out.println("Highest Skill Level : " + skill);
    }
}
