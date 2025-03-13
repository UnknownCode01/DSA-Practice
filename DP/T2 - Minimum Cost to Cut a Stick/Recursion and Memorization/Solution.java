import java.util.*;

class Solution {
    public static int cutRod(int[] price) {
        int n = price.length;
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = i + 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= price.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return cutRodHelper(price, l, n, n, dp);
    }

    public static int cutRodHelper(int[] price, int[] l, int n, int L, int[][] dp) {
        if (n == 0 || L == 0) {
            return 0;
        }
        if (dp[n][L] != -1) {
            return dp[n][L];
        }

        if (l[n - 1] <= L) {
            int take = price[n - 1] + cutRodHelper(price, l, n, L - l[n - 1], dp);
            int notTake = cutRodHelper(price, l, n - 1, L, dp);
            dp[n][L] = Math.max(take, notTake);
        } else {
            dp[n][L] = cutRodHelper(price, l, n - 1, L, dp);
        }
        return dp[n][L];
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(cutRod(price));
    }
}