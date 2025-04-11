class Solution {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        int k = 1;
        for (int i : nums) {
            arr[k++] = i;
        }
        arr[k] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = arr[i - 1] * arr[ind] * arr[j + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, coins);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums));
    }
}