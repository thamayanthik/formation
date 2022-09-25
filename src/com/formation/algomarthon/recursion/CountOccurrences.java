package com.formation.algomarthon.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Write a recursive function named countOccurrences
that accepts two vectors of integers v1 and v2 by reference,
and returns an integer indicating the number of times that the contents of v2 appear in v1.
The contents must be consecutive elements and must occur in the same relative order.

The following table shows several calls to your function and their expected return values.
The occurrences are underlined in the first call as an illustration.

Call	Returns
array1 v1 {1, 4, 2, 4, 2, 1, 4, 2, 9, 1, 4, 2, 0, 1, 4, 2};
array2 v2 {1, 4, 2};
countOccurrences(v1, v2)
4

array1 {8, 8, 8, 4, 8, 8, 8, 8, 2, 8, 1, 8, 7, 8, 8};
array2 {8, 8};
countOccurrences(v1, v2)
6
array1 v1 {1, 2, 3, 2, 1, 4, 1, 2};
array2 v2 {3, 1};
countOccurrences(v1, v2)
0
array1 v1 {1, 2, 3};
array2 v2 {1, 2, 3, 4};
countOccurrences(v1, v2)
0
Note that occurrences of v2 in v1 can partially overlap. For example, in the second call above, there is an occurrence of {8, 8} starting at index 0 in v1, and an overlapping occurrence that starts at index 1. The range of indexes 4-7 contains 3 occurrences of v2: one that starts at index 4, one that starts at index 5, and one that starts at index 6.

When your function returns to the caller, the state of the two vectors passed in must be the same as when your function started. Your function should either not modify the vectors that are passed in, or if it does do so, it should restore their state before returning.

You may assume that v2 is non-empty. If v1 is empty, it does not contain any v2 occurrences, so you should return 0.

Constraints:

Do not create or use any auxiliary data structures like additional queues, stacks, vector, map, set, array, strings, etc.
Do not use any loops; you must use recursion.
Do not declare any global variables. You can declare as many primitive variables like ints as you like.
Your solution should run in no worse than O(N) time, where N is the number of elements in the vectors.
You are allowed to define other "helper" functions if you like; they are subject to these same constraints.

 */
public class CountOccurrences {
    public static void main(String[] args) {
        System.out.println(countOccurrences(new int[]{1, 4, 2, 4, 2, 1, 4, 2, 9, 1, 4, 2, 0, 1, 4, 2},
                new int[]{1, 4, 2}, 0, 0, new ArrayList<>()));
        System.out.println(countOccurrences(new int[]{8, 8, 8, 4, 8, 8, 8, 8, 2, 8, 1, 8, 7, 8, 8},
                new int[]{8, 8}, 0, 0, new ArrayList<>()));
    }

    private static int countOccurrences(int[] arr, int[] target, int sum, int index, List<Integer> ans) {
        if (index >= arr.length) {
            return sum;
        }

        int s = ans.size();

        if (target[s + 1] != arr[index]) {
            ans = new ArrayList<>();
        }

        ans.add(arr[index]);

        if (ans.size() == target.length) {
            sum += 1;
            ans = new ArrayList<>();
        }

        return countOccurrences(arr, target, sum, index + 1, ans);
    }
}
