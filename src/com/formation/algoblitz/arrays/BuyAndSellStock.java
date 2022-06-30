package com.formation.algoblitz.arrays;

public class BuyAndSellStock {
    public static void main(String... str) {
        System.out.println("MaxProfit : " + findBestTimeToSellStock(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println("MaxProfit : " + findBestTimeToSellStock(new int[]{}));

        System.out.println("MaxProfit : " + findBestTimeToSellStock(new int[]{7, 3, 4, 2, 1, 1}));

        System.out.println("MaxProfit : " + findBestTimeToSellStock(new int[]{7, 7, 7, 7, 7, 7}));
    }

    private static int findBestTimeToSellStock(int[] stockPrice) {
        if (stockPrice.length == 0) return 0;

        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 1; i < stockPrice.length; i++) {
            int currentMaxProfit = stockPrice[i] - minPriceSoFar;
            maxProfit = Math.max(maxProfit, currentMaxProfit);

            if (minPriceSoFar > stockPrice[i]) { // Buy newer stock with lower price
                minPriceSoFar = stockPrice[i];
            }
        }
        return maxProfit;
    }
}
