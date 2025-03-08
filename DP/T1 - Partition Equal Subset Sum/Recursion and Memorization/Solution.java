import java.util.Arrays;

class Solution {
    static Boolean f(int index, int arr[], int target, int[][] dp) {
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

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean ans = isSubsetSum(nums, sum / 2);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums));
    }
}