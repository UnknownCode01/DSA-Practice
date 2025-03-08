class Solution {
    public static int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        // Initialization
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= target)
            dp[0][arr[0]] = 1;
        if (arr[0] == 0)
            dp[0][0] = 2;
        // main work
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j >= arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[n - 1][target];
    }

    public static void main(String args[]) {
        int arr[] = { 5, 2, 3, 10, 6, 8 };
        int target = 10;
        System.out.println(perfectSum(arr, target));
    }
}
