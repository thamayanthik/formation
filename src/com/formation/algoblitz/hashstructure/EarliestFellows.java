package com.formation.algoblitz.hashstructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EarliestFellows {
    public static void main(String... str) {
        earliestFellows(Map.of("oliver", 3, "pinky", 1, "pixel", 2, "tobey", 1));
        solution2(Map.of("oliver", 3, "pinky", 1, "pixel", 2, "tobey", 1));
    }

    private static void earliestFellows(Map<String, Integer> input) {
        int min = Integer.MAX_VALUE;
        Iterator<Map.Entry<String, Integer>> itr = input.entrySet().iterator();
        List<String> name = new ArrayList<>();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> map = itr.next();
            min = Math.min(min, itr.next().getValue());
        }

        itr = input.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> map = itr.next();
            int currentMin  = map.getValue();
            String key = map.getKey();
            if (min == currentMin) {
                name.add(key);
            }
        }

        System.out.println(name);
    }

    private static void solution2(Map<String, Integer> input) {
        int min = Integer.MAX_VALUE;
        Iterator<Map.Entry<String, Integer>> itr = input.entrySet().iterator();
        List<String> name = new ArrayList<>();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> map = itr.next();
            int currentMin  = map.getValue();
            String key = map.getKey();
            if (min == currentMin) {
                name.add(key);
            } else if (min > currentMin) {
                min = currentMin;
                name.clear();
                name.add(key);
            }
        }

        System.out.println(name);
    }
}
