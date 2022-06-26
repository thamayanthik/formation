package com.formation.algoblitz;

public class ValidateArrayValuesOrdered {
    public static void main(String... str) {
        int[] array = {2, 4, 3, 5, 6};

        System.out.println("Is Array Ordered ? (Solution1) : " + solution1(array));

        System.out.println("Is Array Ordered ? (Solution2) : " + solution2(array));
    }

    public static boolean solution1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution2(int[] array) {
        for (int i = 1; i < array.length - 1; i = i + 2) {
            if (array[i - 1] > array[i] || array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
