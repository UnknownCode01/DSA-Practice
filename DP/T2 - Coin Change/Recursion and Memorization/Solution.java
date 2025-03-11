import java.util.Arrays;

class Solution {
    public static int f(int[] coins, int index, int target, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (index == 0) {
            if (target % coins[index] == 0) {
                return target / coins[index];
            }
            return Integer.MAX_VALUE - 1;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = 0 + f(coins, index - 1, target, dp);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= target) {
            take = 1 + f(coins, index, target - coins[index], dp);
        }
        return dp[index][target] = Math.min(take, notTake);
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = f(coins, n - 1, amount, dp);
        if (ans == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}