package com.formation.algoblitz.hashstructure;

import java.util.HashMap;
import java.util.Map;

public class RisingTideWinner {
    public static void main(String... str) {
        findRisingTideWinner(new String[]{"oliver", "pixel", "pinky", "pixel"});

        findRisingTideWinner(new String[]{"oliver", "alex", "alex", "alexi", "pixel", "pinky", "pixel"});
    }

    private static void findRisingTideWinner(String[] nominees) {
        Map<String, Integer> awardPerPerson = new HashMap<>();
        int maxAward = Integer.MIN_VALUE;
        String awardWinner = null;
        for (int i = 0; i < nominees.length; i++) {
            int currentCount = awardPerPerson.getOrDefault(nominees[i], 0) + 1;
            awardPerPerson.put(nominees[i], currentCount);

            if (maxAward <= currentCount) {
                if (maxAward == currentCount) {
                    // Compare Both String
                   if (awardWinner.compareTo(nominees[i]) < 0) {
                        awardWinner = nominees[i];
                    }
                } else {
                    awardWinner = nominees[i];
                }

                maxAward = currentCount;
            }
        }

        System.out.println("Winner : " + awardWinner);
    }
}
