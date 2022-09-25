package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    public static void main(String[] args) {
        rollDice(3, new ArrayList<>());
    }

    private static void rollDice(int number, List<Integer> chosen) {
        if (number == 0) {
            System.out.println(chosen);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            chosen.add(i);
            rollDice(number - 1, chosen);
            chosen.remove(chosen.size() - 1);
        }
    }
}
