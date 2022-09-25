package com.formation.algomarthon.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SplitWiseAccountBalancing {
    public static void main(String[] args) {
        System.out.println(minTransfers(new int[][]{{0, 1, 10}, {2, 0, 5}}));
    }

    public static int minTransfers(int[][] transactions) {

        int[] debt = buildDebt(transactions);

        return getMinTransfer(debt, 0);
    }

    private static int getMinTransfer(int[] debt, int index) {
        while (index < debt.length && debt[index] == 0) {
            index++;
        }

        if (index >= debt.length) {
            return 0;
        }

        // Back Tracking Steps: Choose, Explore, Unchoose

        int minTransfer = Integer.MAX_VALUE;
        for (int i = index; i < debt.length - 1; i++) {
            if (debt[i + 1] < 0 || debt[index] < 0) {
                debt[i + 1] += debt[index]; // choose
                minTransfer = Math.min(minTransfer, getMinTransfer(debt, index + 1) + 1);
                debt[i + 1] -= debt[index]; // remove selected value
            }
        }
        return minTransfer;
    }

    private static int[] buildDebt(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            int owner = transactions[i][0];
            int borrower = transactions[i][1];
            int amount = transactions[i][2];
            balance.put(owner, balance.getOrDefault(owner, 0) + amount);
            balance.put(borrower, balance.getOrDefault(borrower, 0) - amount);
        }

        int[] debt = new int[balance.size()];
        int index = 0;
        for (int amount : balance.values()) {
            if (amount != 0) {
                debt[index++] = amount;
            }
        }

        //System.out.println("Dept : " + Arrays.toString(dept));

        return debt;
    }
}
