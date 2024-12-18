import java.util.*;
class Solution{
    public static int minimumEnergy(int arr[],int n, int k){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j] + Math.abs(arr[i]-arr[i-j]);
                    minSteps = Math.min(minSteps,jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }
    public static void main(String[] args){
        int arr[] = {10,20,30,10};
        int n = 4;
        int k = 2;
        System.out.println(minimumEnergy(arr,n,k));
    }
}
