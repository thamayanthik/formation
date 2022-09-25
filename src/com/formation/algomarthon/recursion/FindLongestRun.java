package com.formation.algomarthon.recursion;

public class FindLongestRun {
    public static void main(String[] args) {
        System.out.println(maxRunningSequence(new int[]{4, 8, 8, 21, 5, 2, 6, 8, 6, 2, 1, 3, 3, 3, 17, 9, 8, 11},
                Integer.MIN_VALUE, 0, 0));
    }

    private static int maxRunningSequence(int[] arr, int maxSeq, int runningSeq, int index) {
        if (index >= arr.length - 1) {
            return maxSeq;
        }

        if (arr[index] <= arr[index + 1]) {
            runningSeq++;
        } else {
            maxSeq = Math.max(maxSeq, runningSeq);
            runningSeq = 1;
        }

        return maxRunningSequence(arr, maxSeq, runningSeq, index + 1);

    }
}
