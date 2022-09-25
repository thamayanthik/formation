package com.formation.algomarthon.array;


import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private int[] input;

    public ShuffleArray(int[] nums) {
        input = nums;
    }

    public static void main(String[] args) {
        ShuffleArray s = new ShuffleArray(new int[] {1, 2, 3});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));
    }

    public int[] reset() {
        return input;
    }

    public int[] shuffle() {

        Random random = new Random();
        int[] newNums = new int[input.length];

        System.arraycopy(input, 0, newNums, 0, input.length);

        for (int i = input.length - 1; i > 0; i--) {
            int j = random.ints(0, i)
                    .findFirst()
                    .getAsInt();
            int tmp = newNums[i];
            newNums[i] = newNums[j];
            newNums[j] = tmp;
        }


        return newNums;
    }
}
