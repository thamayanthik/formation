package com.formation.algomarthon;

import java.util.*;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        arrangeUsingLib(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {2, 0, 2, 1, 1, 0};
        usingCount(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2,0,1};
        onePass(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private static void arrangeUsingLib(int[] arr) {
        Arrays.sort(arr);
    }

    private static void usingCount(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0 ) + 1);
        }

        Set<Integer> keys = count.keySet();

        int i = 0;
        for (int key : keys) {
            Integer values = count.get(key);
            while (values > 0) {
                arr[i++] = key;
                values--;
            }
        }
    }

    private static void onePass(int[] arr) {
        int curr = 0, pos0 = 0;
        int p2 = arr.length - 1;
        while (curr <= p2) {
            if (arr[curr] == 0) {
                int tmp = arr[pos0];
                arr[pos0++] = arr[curr];
                arr[curr++] = tmp;
            } else if (arr[curr] == 2) {
                int tmp = arr[p2];
                arr[p2--] = arr[curr];
                arr[curr] = tmp;
            } else {
                curr++;
            }
        }

    }
}
