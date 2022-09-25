package com.formation.algomarthon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        List<Integer[]> result = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        for (Integer[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> result = new ArrayList<Integer[]>();
        for (int i = 0; i < array.length; i++) {
            int currentSum = array[i];
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int target = currentSum + array[left] + array[right];
                if (target == targetSum) {
                    result.add(new Integer[] {currentSum, array[left], array[right]});
                    left++;
                    right--;
                } else if (target < targetSum) {
                    left++;
                }  else if (target > targetSum) {
                    right--;
                }

            }
        }

        return result;
    }
}
