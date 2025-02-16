class Solution {
    public static int minCoins(int coins[], int sum) {
        int m = coins.length;
        int[][] dp = new int[m + 1][sum + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                } else if (i == 1) {
                    if (j % coins[0] == 0)
                        dp[i][j] = j / coins[0];
                    else
                        dp[i][j] = Integer.MAX_VALUE - 1;
                }

                else if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[m][sum] == Integer.MAX_VALUE - 1) {
            return -1;
        } else {
            return dp[m][sum];
        }
    }

    public static void main(String[] args) {
        int[] coins = { 10, 4, 3 };
        int amount = 16;
        System.out.println(minCoins(coins, amount));
    }
}