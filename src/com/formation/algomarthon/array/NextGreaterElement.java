package com.formation.algomarthon.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println("Expected : " + Arrays.toString(nextGreaterElements(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7})));
    }

    private static int[] nextGreaterElements(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        for (int j = 0; j < nums1.length; j++) {
            int index = indexMap.get(nums1[j]);
            int max = -1;
            while (index + 1 < nums2.length) {
                if (nums2[index + 1] > nums1[j]) {
                    max = Math.max(max, nums2[index + 1]);
                    break;
                }
                index++;
            }
            res[j] = max;
        }
        return res;
    }
}
