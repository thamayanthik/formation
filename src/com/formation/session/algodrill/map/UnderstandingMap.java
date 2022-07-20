package com.formation.session.algodrill.map;

import java.util.*;

/**
 * You are given an array of dictionaries/maps mapping Fellows to post session performance ratings.
 * <p>
 * Here's an example:
 * [ {"oliver": 2, "pixel": 1, "pinky": 4}, {"michael": 2, "oliver": 3, "pinky": 3}, {"michael": 1, "oliver": 1, "pixel": 1}]
 * <p>
 * Return the Fellow with the highest average rating ("pinky")
 * Return the Fellow with the lowest average rating ("pixel")
 * Return the Fellow with the most consistent rating ("pixel")
 * Return the Fellow that was in the mostnumber of sessions ("oliver")
 */
public class UnderstandingMap {
    public static void main(String[] args) {

        Map<String, Integer> f1 = Map.of("oliver", 2, "pixel", 1, "pinky", 4);
        Map<String, Integer> f2 = Map.of("michael", 2, "oliver", 3, "pinky", 3);
        Map<String, Integer> f3 = Map.of("michael", 1, "oliver", 1, "pixel", 1);

        System.out.println(highestAvgRatingFellow(List.of(f1, f2, f3)));

    }

    private static String highestAvgRatingFellow(List<Map<String, Integer>> sessions) {
        Map<String, Integer> rating = new HashMap<>();
        Map<String, Integer> sessionCount = new HashMap<>();

        for (Map<String, Integer> session : sessions) {
            session.entrySet().stream()
                    .forEach(e -> {
                        rating.put(e.getKey(), rating.getOrDefault(e.getKey(), 0) + e.getValue());
                        sessionCount.put(e.getKey(), sessionCount.getOrDefault(e.getKey(), 0) + 1);
                    });
        }

        String highAvgFellow = null;
        Integer maxAvg = Integer.MIN_VALUE;

        Set<Map.Entry<String, Integer>> entrySet = rating.entrySet();
        Iterator<Map.Entry<String, Integer>> itr = entrySet.iterator();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            int currentAvg = entry.getValue() / sessionCount.get(entry.getKey());
            if (currentAvg > maxAvg) {
                maxAvg = currentAvg;
                highAvgFellow = entry.getKey();
            }
        }

        return highAvgFellow;
    }
}
