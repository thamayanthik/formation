package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> res =
                findCombination(new int[]{2,3,5}, 0, 8, new ArrayList<>(), new ArrayList<>());
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }

    private static List<List<Integer>> findCombination(int[] arr, int index, int target,
                                                       List<List<Integer>> res, List<Integer> ans) {

       if (target == 0) {
           res.add(List.copyOf(ans));
           return res;
        }

        if (index >= arr.length || target < 0) {
           return res;
        }

        // include the value, to choose the value
        ans.add(arr[index]);

        findCombination(arr, index, target - arr[index], res, ans);

        // exclude the value, remove previously added value
        ans.remove(ans.size() - 1);

        findCombination(arr, index + 1, target, res, ans);

        return res;
    }
}
