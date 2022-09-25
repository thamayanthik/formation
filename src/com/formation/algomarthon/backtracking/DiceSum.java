package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceSum {
    public static void main(String[] args) {
        diceSum(3, 0);
    }

    private static void diceSum(int number, int sum) {
        if (number == 0) {
            System.out.println(sum);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            sum += i;
            diceSum(number - 1, sum);
            sum -= i;
        }
    }
}
