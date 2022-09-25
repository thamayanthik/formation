package com.formation.algomarthon.backtracking;

import java.util.Arrays;

public class CanCalculateSum {
    public static void main(String[] args) {
        System.out.println(canCalculateSum(new int[]{2, 2, 3}, 6));
    }

    private static boolean canCalculateSum(int[] arr, int target) {
        if (target == 0) {
            return true;
        }

        if (target < 0 || arr.length <= 0) {
            return false;
        }

        // Choose,

        int num = arr[0];
        int[] newArr = new int[arr.length - 1];
        // Explore,
        boolean exclude = canCalculateSum(newArr, target);
        boolean include = canCalculateSum(newArr, target - num);
        if (exclude || include) {
            /* // UnChoose not required in this case
            newArr = new int[arr.length + 1];
            System.arraycopy(arr, 0, newArr, 1, newArr.length);
            newArr[0] = num;
            arr = newArr;*/
            return true;
        }

       return false;

    }
}
