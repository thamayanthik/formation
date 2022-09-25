package com.algodrill.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetGeneration {
    public static void main(String[] args) {
        List<List<Integer>> output = generateSubSet(new int[]{1, 2, 3});
        for (List<Integer> out : output) {
            System.out.println(out);
        }

        List<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);

        System.out.println("----------------------------------------");
        output =  new ArrayList<>();
        output = printAllSublistUsingBackTracking(in, new ArrayList<>(), output);
        for (List<Integer> out : output) {
            System.out.println(out);
        }
    }

    private static List<List<Integer>> generateSubSet(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            List<Integer> fe = new ArrayList<>();
            fe.add(arr[i]);
            subSet(new Integer[]{arr[i]}, Arrays.copyOfRange(arr, i + 1, arr.length), result);
        }

        return result;
    }

    private static List<List<Integer>> subSet(Integer[] arr, int[] res, List<List<Integer>> output) {

        output.add(Arrays.asList(arr));

        if (res.length > 0) {
            for (int i = 0; i < res.length; i++) {
                Integer[] newArr = new Integer[arr.length + 1];
                System.arraycopy(arr, 0, newArr, 0, newArr.length - 1);
                newArr[arr.length] = res[i];
                subSet(newArr, Arrays.copyOfRange(res, i + 1, res.length), output);
            }
        }

        return output;
    }

    private static List<List<Integer>> printAllSublistUsingBackTracking(List<Integer> v, List<Integer> chosen, List<List<Integer>> res) {
        if (v.isEmpty()) {
            // if chosen added without copy, actual result will be modified when chosen changed during backtrack
            res.add(List.copyOf(chosen));
            return res;
        } else {
            int val = v.get(0);
            v.remove(0);
            //chose
            chosen.add(val);
            // explore
            printAllSublistUsingBackTracking(v, chosen, res); // generate list chosen value
            chosen.remove(chosen.size() - 1);
            printAllSublistUsingBackTracking(v, chosen, res); // generate list without chosen value
            // un-choose
            v.add(0, val);
        }

        return res;
    }
}
