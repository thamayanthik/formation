package com.formation.algomarthon.array;

public class ShiftedBinarySearch {
    public static void main(String[] args) {
        System.out.println(shiftedBinarySearch(new int[]{72, 73, 0, 1, 21, 33, 37, 45, 61, 71}, 72));
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[left] < array[mid]) {
                if (target < array[mid] && target >= array[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > array[mid] && target <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
