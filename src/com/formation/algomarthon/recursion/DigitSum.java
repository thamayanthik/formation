package com.formation.algomarthon.recursion;

public class DigitSum {
    public static void main(String[] args) {
        System.out.println(digitSum(1729));
    }

    private static int digitSum(int number) {
        if (number == 0) {
            return 0;
        }

        return (number % 10) + digitSum(number / 10);
    }
}
