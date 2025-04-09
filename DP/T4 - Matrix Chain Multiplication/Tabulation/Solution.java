class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = arr[i - 1] * arr[k] * arr[j] + dp[i][k]+dp[k + 1][j];
                    mini = Math.min(mini, temp);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3 };
        System.out.println(matrixMultiplication(arr));
    }
}