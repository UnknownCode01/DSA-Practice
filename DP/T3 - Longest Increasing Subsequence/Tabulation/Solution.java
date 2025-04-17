class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr-1; prev >= -1; prev--) {
                int notTake = dp[prev+1][curr+1];
                int take = 0;
                if (prev == -1 || nums[prev] < nums[curr]) {
                    take = 1 + dp[curr+1][curr+1];
                }
                dp[prev + 1][curr] = Math.max(notTake, take);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }
}