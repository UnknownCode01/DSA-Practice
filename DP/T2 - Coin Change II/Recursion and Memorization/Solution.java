import java.util.Arrays;

class Solution {
    public static int f(int[] coins, int index, int target, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            return target % coins[index] == 0 ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = f(coins, index - 1, target, dp);
        int take = 0;
        if (coins[index] <= target) {
            take = f(coins, index, target - coins[index], dp);
        }
        return dp[index][target] = take + notTake;
    }

    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = f(coins, n - 1, amount, dp);
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println(change(amount, coins));
    }
}