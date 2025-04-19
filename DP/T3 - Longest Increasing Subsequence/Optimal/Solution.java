import java.util.Arrays;

class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int temp = 1 + dp[j];
                    dp[i] = Math.max(temp, dp[i]);
                }
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(i, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }
}