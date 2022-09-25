package com.formation.algomarthon.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParentToChild {
    public static void main(String[] args) {
        printParentChild(new String[][]{{"James", "Ben", "Lisa"}, {"George", "Taylor", "Fred"}, {"Jen", "Ben", "Gloria"}});
    }

    private static void printParentChild(String[][] pc) {
        Map<String, Set<String>> pcr = new HashMap<>();
        for (int i = 0; i < pc.length; i++) {
            String p1 = pc[i][1];
            String p2 = pc[i][2];
            String c = pc[i][0];
            Set<String> child1 = pcr.getOrDefault(p1, new HashSet<>());
            child1.add(c);
            Set<String> child2 = pcr.getOrDefault(p2, new HashSet<>());
            child2.add(c);

            pcr.put(p1, child1);
            pcr.put(p2, child2);
        }

        pcr.entrySet().stream().forEach(p -> {
            System.out.println(p.getKey() + " is the parent of " + p.getValue());
        });
    }
}
