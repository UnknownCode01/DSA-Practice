import java.util.*;

class Solution {
    public static int minCost(int n, int[] cuts) {
        int c = cuts.length + 2;
        int[] arr = new int[c];
        arr[0] = 0;
        int k = 1;
        for (int i : cuts) {
            arr[k++] = i;
        }
        arr[k] = n;
        Arrays.sort(arr);
        int[][] dp = new int[c][c];

        for (int i = c - 2; i >= 1; i--) {
            for (int j = 1; j <= c - 2; j++) {
                if (i > j) {
                    continue;
                }
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr[j + 1] - arr[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c - 2];
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = { 1, 3, 4, 5 };
        System.out.println(minCost(n, cuts));
    }
}