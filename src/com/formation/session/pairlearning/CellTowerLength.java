package com.formation.session.pairlearning;

public class CellTowerLength {
    public static void main(String[] args) {
        System.out.println(search(new int[]{0, 5, 11}, new int[]{0, 2, 6, 10}));
        // System.out.println(search(new int[]{2, 6}, new int[]{4}));
    }

    private static int search(int[] customers, int[] towers) {
        int maxSoFar = 0;
        int cusPos = 0, towPos = 0;
        while (cusPos < customers.length) {
            while (towPos < towers.length - 1
                    && Math.abs(customers[cusPos] - towers[towPos + 1]) < Math.abs(customers[cusPos] - towers[towPos])) {
                towPos++;
            }
            maxSoFar = Math.max(maxSoFar, Math.abs(customers[cusPos] - towers[towPos]));
            cusPos++;
        }

        return maxSoFar;
    }
}
