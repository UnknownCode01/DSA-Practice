import java.util.Arrays;

class Solution {
    static int f(int index, int arr[], int target, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0)
                return 2; // Two ways: pick or not pick zero
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notTake = f(index - 1, arr, target, dp);
        int take = 0;
        if (target >= arr[index]) {
            take = f(index - 1, arr, target - arr[index], dp);
        }
        dp[index][target] = notTake + take;
        return dp[index][target];
    }

    public static int perfectSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        int x = f(arr.length - 1, arr, target, dp);
        return x;
    }

    static int findTargetSumWays(int[] arr, int d) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (Math.abs(d) > sum) return 0;
        if ((d + sum) % 2 != 0) {
            return 0;
        }
        int target = (d + sum) / 2;
        if (target > sum) {
            return 0;
        }
        return perfectSum(arr, target);
    }

    public static void main(String[] args) {
        int[] arr = { 1,1,1,1,1};
        int d = 3;
        System.out.println(findTargetSumWays(arr, d));
    }
}