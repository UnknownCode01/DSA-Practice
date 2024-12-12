import java.util.*;
class Solution{
    public static int knapsack1(int[] val, int[] wt, int W, int n){
        if(n==0 || W==0){
            return 0;
        }
        if(wt[n-1]<=W){
            int ans1 = val[n-1]+knapsack1(val,wt,W-wt[n-1],n-1);
            int ans2 = knapsack1(val,wt,W,n-1);
            return Math.max(ans1,ans2);
        }else{
            return knapsack1(val,wt,W,n-1);
        }
    }

    public static int knapsack2(int[] val, int[] wt, int W, int n, int[][] dp){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            int ans1 = val[n-1]+knapsack2(val,wt,W-wt[n-1],n-1,dp);
            int ans2 = knapsack2(val,wt,W,n-1,dp);
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else{
            dp[n][W] = knapsack2(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args){
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;  // Capacity
        int[][] dp = new int[val.length+1][W+1];
        for (int i = 0; i <= val.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsack1(val,wt,W,val.length));
        System.out.println(knapsack2(val,wt,W,val.length,dp));
    }
}