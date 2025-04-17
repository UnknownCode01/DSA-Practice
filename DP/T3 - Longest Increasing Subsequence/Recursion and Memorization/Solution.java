import java.util.*;

class Solution {
    public static int f(int[] nums, int prev, int curr, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }
        if (dp[prev + 1][curr] != -1) {
            return dp[prev + 1][curr];
        }
        int notTake = f(nums, prev, curr + 1, dp);
        int take = 0;
        if (prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + f(nums, curr, curr + 1, dp);
        }
        return dp[prev + 1][curr] = Math.max(notTake, take);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return f(nums, -1, 0, dp);
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }
}