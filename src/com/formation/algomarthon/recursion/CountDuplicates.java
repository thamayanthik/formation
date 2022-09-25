package com.formation.algomarthon.recursion;

/**
 * Write a recursive function named countDuplicates that accepts a reference to a stack of
 * integers as its parameter and returns a count of the total number of duplicate elements in the stack.
 * You may assume that the stack's contents are a sorted collection of non-negative integers,
 * and therefore that all duplicate values will be stored consecutively in the stack.
 * For example, given a stack named st containing the following elements:
 *
 * bottom                                                              top
 * {1, 3, 4, 7, 7, 7, 7, 9, 9, 11, 13, 14, 14, 14, 16, 16, 18, 19, 19, 19}
 * In the above example, there are 9 total duplicate values (underlined for clarity): three 7s, a 9, two 14s, a 16,
 * and two 19s. So the call of countDuplicates(st); should return 9.
 * Notice that there might be several duplicates in a row, as with 7, 14, and 19.
 *
 * Your function should not make any externally visible changes to the stack passed in.
 * That is, you should either not modify the stack passed, or if you do modify it,
 * you must restore it back to its exact original state before your overall function returns.
 *
 * Input: Sorted Array
 * Constraints:
 * Do not use any loops; you must use recursion.
 * Do not create or use any auxiliary data structures like additional queues, stacks, vector, map, set, array, strings, etc. You should also not call functions that return multi-element regions of a vector, such as sublist.
 * Do not solve this problem using "string hacks" related to the to_string result of a stack, such as by calling to_string() and then searching for commas or other patterns.
 * Do not declare any global variables. You can declare as many primitive variables like ints as you like.
 * Your solution should run in no worse than O(N) time, where N is the number of elements in the stack.
 * You are allowed to define other "helper" functions if you like; they are subject to these same constraints.
 */
public class CountDuplicates {
    public static void main(String[] args) {
        System.out.println(countDuplicates(new int[]{1, 3, 4, 7, 7, 7, 7, 9, 9, 11, 13, 14, 14, 14, 16, 16, 18, 19, 19, 19}, 1, 1, 0));
        System.out.println(countDuplicates(new int[]{1, 2, 2, 2, 2, 3, 3}, 1, 1, 0));
    }

    private static int countDuplicates(int[] arr, int lastValue, int index, int sum) {
        if (arr.length == index) {
            return sum;
        } else if (arr[index] == lastValue) {
           sum += 1;
        }

        return countDuplicates(arr, arr[index], index + 1, sum);
    }
}
