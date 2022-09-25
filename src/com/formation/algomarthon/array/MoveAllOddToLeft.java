package com.formation.algomarthon.array;

import java.util.Arrays;

public class MoveAllOddToLeft {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveAllOddToLeft(new int[]{2, 4, 6, 7, 9, 1, 3})));
    }

    private static int[] moveAllOddToLeft(int[] array) {
        boolean ordered = false;
        while (!ordered) {
            int low = 0;
            int next = low + 1;
            ordered = true;
            while (low <= array.length - 2) {
                if (array[low] % 2 == 0 && array[next] % 2 != 0) {
                    int tmp = array[next];
                    array[next] = array[low];
                    array[low] = tmp;
                    ordered = false;
                }
                low++;
                next++;
            }
        }


        return array;
    }
}
