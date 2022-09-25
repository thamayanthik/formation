package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        generateGrayCode(3);
    }

    private static void generateGrayCode(int n) {
        int maxValue = (int) Math.pow(2, n) - 1;
        System.out.println("Max Length : " + (1 << n));
        System.out.println("MaxValue : " + maxValue);
        System.out.println(generate(maxValue, 0, new ArrayList<>()));
    }

    private static List<Integer> generate(int maxValue, int number, List<Integer> res) {

        for (int i = 0; i <= maxValue; i++) {
            int xor = i >> 1;
            int num = i ^ xor;
            res.add(num);
        }

        return res;
    }
}
