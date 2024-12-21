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
        if(n==1){
            return nums[0];
        }
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0){
                nums1[i-1] = nums[i];
            }
            if(i!=n-1){
                nums2[i] = nums[i];
            }
        }
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int ans1 = f(n-2,dp1,nums1);
        int ans2 = f(n-2,dp2,nums2);
        return Math.max(ans1, ans2);
    }
    public static void main(String[] args){
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }
}