package com.formation.algoblitz.arrays.speeddrill;

public class BiggestPariDiff {

    int[] solution(int[] array) {
        if (array.length == 2) {
            return array;
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
