class Solution {
    static int f(int arr[], int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = arr[i - 1] * arr[k] * arr[j] + f(arr, i, k, dp) + f(arr, k + 1, j, dp);
            mini = Math.min(mini, temp);
        }
        return dp[i][j] = mini;
    }

    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return f(arr, 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3 };
        System.out.println(matrixMultiplication(arr));
    }
}