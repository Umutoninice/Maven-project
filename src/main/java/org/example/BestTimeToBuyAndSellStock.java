package org.example;

/**
 * LeetCode 121: Best Time to Buy and Sell Stock
 * Given an array prices where prices[i] is the price of a stock on day i,
 * find the maximum profit achievable by buying on one day and selling on a
 * later day. Return 0 if no profit is possible.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPriceSoFar = prices[0];
        int maxProfitSoFar = 0;

        // Single pass: at each day, track the lowest price seen so far
        // (best possible buy point) and the best profit achievable by
        // selling on the current day.
        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - minPriceSoFar;
            maxProfitSoFar = Math.max(maxProfitSoFar, profitIfSoldToday);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }

        return maxProfitSoFar;
    }

    // Time complexity: O(n) - a single linear pass through the prices array.
    // Space complexity: O(1) - only two variables (minPriceSoFar,
    //                   maxProfitSoFar) are used regardless of input size.

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();
        System.out.println(solver.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 5
        System.out.println(solver.maxProfit(new int[] { 7, 6, 4, 3, 1 }));    // 0
    }
}

