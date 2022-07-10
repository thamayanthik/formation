package com.formation.algoblitz.arrays.speeddrill;

/**Given an array of integers, find the first occurring adjacent pair with the biggest difference.**/

/**
 * Example:
 * Input: [1, 2, 3, 10, 4, 11]
 * Output: [3, 10] // difference of 7; notice [4, 11] also differs by 7
 */
public class BiggestPariDiff {

    int[] solution(int[] array) {
        if (array.length <= 1) {
            return new int[] {};
        }

        int[] result = new int[] {};
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            int diff = Math.abs(array[i] - array[i+1]);
            if (diff > max) {
                max = diff;
                result = new int[] {array[i], array[i+1]};
            }
        }

        return result;
    }

}
