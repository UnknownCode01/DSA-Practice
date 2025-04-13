import java.util.*;

class Solution {
    public static int f(int i, int j, int[] arr, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = arr[j + 1] - arr[i - 1] + f(i, ind - 1, arr, dp) + f(ind + 1, j, arr, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }

    public static int minCost(int n, int[] cuts) {
        int c = cuts.length+2;
        int[] arr = new int[c];
        arr[0] = 0;
        int k = 1;
        for (int i : cuts) {
            arr[k++] = i;
        }
        arr[k] = n;
        Arrays.sort(arr);
        int[][] dp = new int[c][c];
        return f(1, c - 2, arr, dp);
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = { 1, 3, 4, 5 };
        System.out.println(minCost(n, cuts));
    }
}