package com.algodrill.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Define a chain of a list L to be a sequence of elements from L, not necessarily contiguous,
that are arranged in ascending order in L. For instance, in the list [1, 3, 2, 4],
valid chains include [1], [1, 3], [1, 3, 4], [1, 2, 4], and [1, 4].

Given an input list, compute the length of its longest chain. List elements are guaranteed to be unique. Examples:

getLengthOfLongestChain([1, 2, 3, 4])              -> 4  // [1, 2, 3, 4]
getLengthOfLongestChain([4, 3, 2, 1])              -> 1  // [1], [2], [3], or [4]
getLengthOfLongestChain([1, 3, 2, 4])              -> 3  // [1, 3, 4] or [1, 2, 4]
getLengthOfLongestChain([1, 3, 2, 4, 5, 8, 6, 7])  -> 6  // [1, 2, 4, 5, 6, 7]
getLengthOfLongestChain([10, 2, 7, 3, 6, 1, 4, 5]) -> 4  // [2, 3, 4, 5]

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */

public class LengthOfLongestChain {
    public static void main(String[] args) {
        int longestChain = generateSubSet(new int[]{1, 2, 3});
        System.out.println(longestChain);
        longestChain = generateSubSet(new int[]{1, 2, 4, 5, 6, 7});
        System.out.println(longestChain);
        longestChain = generateSubSet(new int[]{10, 2, 7, 3, 6, 1, 4, 5});
        System.out.println(longestChain);

        int[] arr = {1, 2, 3}; // {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        System.out.print("The length of the LIS is "
                + usingBackTracking(arr, 0, arr.length, Integer.MIN_VALUE));
    }

    private static int generateSubSet(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            List<Integer> fe = new ArrayList<>();
            fe.add(arr[i]);
            generateAllSubSets(new Integer[]{arr[i]}, Arrays.copyOfRange(arr, i + 1, arr.length), result);
        }

        int longest = 0;
        for (List<Integer> out : result) {
            longest = Math.max(longest, out.size());
        }

        return longest;
    }

    private static List<List<Integer>> generateAllSubSets(Integer[] arr, int[] res, List<List<Integer>> output) {

        // Check is Valid
        boolean valid = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                valid = false;
                break;
            }
        }

        if (valid) {
            output.add(Arrays.asList(arr));
        }

        if (res.length > 0) {
            for (int i = 0; i < res.length; i++) {
                Integer[] newArr = new Integer[arr.length + 1];
                System.arraycopy(arr, 0, newArr, 0, newArr.length - 1);
                newArr[arr.length] = res[i];
                generateAllSubSets(newArr, Arrays.copyOfRange(res, i + 1, res.length), output);
            }
        }

        return output;
    }

    private static int usingBackTracking(int[] arr, int index, int len, int prev) {
        if (index == len) {
            return 0;
        }

        //Step 1: Choose : exclude (not adding 1)
        int excl = usingBackTracking(arr, index + 1, len, prev);
        int incl = 0;
        if (arr[index] > prev) {
            incl = 1 + usingBackTracking(arr, index + 1, len, arr[index]);
        }

        // return the maximum of the above two choices
        return Integer.max(incl, excl);
    }
}
