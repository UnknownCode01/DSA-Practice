import java.util.Arrays;

class Solution {
    static Boolean f(int index, int arr[], int target, int[][] dp) {
        // System.out.println(index + "->" + arr[index] + " " + target + " ");
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == arr[index];
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }
        boolean notTake = f(index - 1, arr, target, dp);
        boolean take = false;
        if (target >= arr[index]) {
            take = f(index - 1, arr, target - arr[index], dp);
        }
        dp[index][target] = notTake || take ? 1 : 0;
        return dp[index][target] == 1;
    }

    static Boolean isSubsetSum(int arr[], int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(arr.length - 1, arr, target, dp);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int target = 9;
        System.out.println(isSubsetSum(arr, target));
    }
}