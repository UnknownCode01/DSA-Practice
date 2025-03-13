import java.util.*;
class Solution{
    static int knapSack(int val[], int wt[], int W) {
        int n = val.length;
        int[][] dp = new int[val.length+1][W+1];
        for (int i = 0; i <= val.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return knapSackHelper(val, wt, W, n, dp);
    }
    public static int knapSackHelper(int[] val, int[] wt, int W, int n, int[][] dp){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            int take = val[n-1]+knapSackHelper(val,wt,W-wt[n-1],n,dp);
            int notTake = knapSackHelper(val,wt,W,n-1,dp);
            dp[n][W] = Math.max(take,notTake);
            return dp[n][W];
        }else{
            dp[n][W] = knapSackHelper(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args){
        int[] val = {6, 1, 7, 7};
        int[] wt = {1, 3, 4, 5};
        int W = 8;  // Capacity
        System.out.println(knapSack(val,wt,W));
    }
}