import java.util.*;
class Solution{
    public static int f(int index, int[] dp, int[] nums) {
        if(index==0){
            return nums[0];
        }
        if(index<0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick = nums[index] + f(index-2,dp,nums);
        int notPick = 0 + f(index-1,dp,nums);
        return dp[index] = Math.max(pick,notPick);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,dp,nums);
    }
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}