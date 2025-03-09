// import java.util.*;

import java.util.ArrayList;

class Solution {
    public static int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int temp : arr) {
            sum += temp;
        }
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= sum; i++) {
            if (dp[n - 1][i] == true) {
                list.add(i);
            }
        }
        int ind = list.size() / 2;
        int e1 = list.get(ind);
        int e2 = sum - e1;
        int miniDiff = Math.abs(e1 - e2);

        return miniDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 6, 11, 5 };
        System.out.println(minDifference(arr));
    }
}