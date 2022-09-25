package com.formation.algomarthon.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHanoi {
    public static void main(String[] args) {
        findPossibleWay(3);
    }

    private static String[] findPossibleWay(int n) {
        List<String> ans = new ArrayList<>();

        moveDisk(n, "A", "B", "C", ans);

        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {

            res[i] = ans.get(i);
        }

        return res;
    }

    /*
      3-> A, B, C -> Expected 3 should goto C (target)
      2-> A, C, B -> Expected 2 should goto B (spare)
      1-> A, B, C -> Expected 1 should goto C (spare)
      1-> A,
     */
    private static void moveDisk(int n, String source, String spare, String target, List<String> ans) {
        if (n > 0) {
            moveDisk(n - 1, source, target, spare, ans);

            ans.add("Disk " + n + " moved to " + target);
            // after moving all the rod from source, source act as spare
            // [as at this point source is empty and spare contains rest of the rods] So we need to swap
            moveDisk(n - 1, spare, source, target, ans);
        }
    }
}
