package com.formation.algomarthon.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapSum {
    Map<String, Integer> values = new HashMap<>();

    public MapSum() {

    }

    public void insert(String key, int val) {
        values.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        Iterator<Map.Entry<String, Integer>> itr = values.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> map = itr.next();
            if (map.getKey().startsWith(prefix)) {
                sum += map.getValue();
            }
        }


        return sum;
    }

    
}
