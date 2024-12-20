import java.util.*;
class Solution{
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>=2){
                pick += dp[i-2];
            } 
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notPick); 
        }
        return dp[n-1];
    }
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}