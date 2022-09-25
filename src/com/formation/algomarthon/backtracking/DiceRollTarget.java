package com.formation.algomarthon.backtracking;

public class DiceRollTarget {
    private static int callCount = 0;

    public static void main(String[] args) {
        diceSum(3, 0, 4);
        System.out.println("Call Count " + callCount);
    }

    private static void diceSum(int number, int sum, int desiredSum) {
        callCount++;
        System.out.println("sum : " + sum + ", number : " + number);
        if (number == 0 && desiredSum == sum) {
            System.out.println(sum);
            return;
        } else if (number == 0 && (sum > desiredSum || sum < desiredSum)) {
            System.out.println("ignored value : " + sum);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            int minSum = sum + i + 1 * (number - 1);
            int maxSum = sum + i + 6 * (number - 1);
            System.out.println("sum : " + sum + ", minSum " + minSum + ", maxSum : " + maxSum);
            if (minSum <= desiredSum
                    && maxSum >= desiredSum) { // it is like between
                diceSum(number - 1, sum + i, desiredSum);
            } else {
                System.out.println("skipping");
            }
        }
    }
}
