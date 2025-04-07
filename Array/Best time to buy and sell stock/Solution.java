public class Solution {
    public static int bestTimeToBuyAndSellStock(int[] prices) {
        int profit = 0;
        int mini = prices[0];
        int cost;
        for (int i = 0; i < prices.length; i++) {
            cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 4, 3, 6 };
        System.out.println(bestTimeToBuyAndSellStock(prices));
    }
}
