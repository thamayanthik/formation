package com.formation.algoblitz.arrays.speeddrill;

import com.formation.algoblitz.linkedlist.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveOddValues {
    public static void main(String[] args) {
        System.out.println("Result : " + Arrays.toString(removeOddValuesFromOddPos(new int[]{1, 2, 3, 4, 5, 6})));
    }

    public static int[] removeOddValuesFromOddPos(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            System.out.println(i % 2);
            if (i % 2 == 0 || (i % 2 != 0 && nums[i - 1] % 2 == 0)) {
                result.add(nums[i - 1]);
            }
        }

        // convert list to Array

        if (result.size() == 0) {
            return new int[]{};
        }

        int[] output = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            output[index] = result.get(index);
        }


        return output;
    }
}
