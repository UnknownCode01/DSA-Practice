//Memory Limit Exceeded
class Solution {
    public static int f(int index, int jumps, int[] nums, int[][] dp) {
        if (index >= nums.length - 1) {
            return jumps;
        }
        if(dp[index][jumps]!=0){
            return dp[index][jumps];
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            mini = Math.min(mini, f(index + i, jumps + 1, nums, dp));
            // System.out.println("mini: "+mini);
        }
        return dp[index][jumps]=mini;

    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return f(0, 0, nums, dp);
    }

    public static void main(String[] args) {
        int[] nums = { 2,3,1,1,4 };
        System.out.println(jump(nums));
    }
}