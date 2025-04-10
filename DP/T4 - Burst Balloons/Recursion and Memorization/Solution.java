import java.util.Arrays;

class Solution {
    public static int f(int[] arr, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1] + f(arr, i, k - 1, dp) + f(arr, k + 1, j, dp);
            maxi = Math.max(maxi, coins);
        }
        return dp[i][j] = maxi;
    }

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int c = n + 2;
        int[] arr = new int[c];
        arr[0] = 1;
        int k = 1;
        for (int i : nums) {
            arr[k++] = i;
        }
        arr[k] = 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(arr, 1, n, dp);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums));
    }
}