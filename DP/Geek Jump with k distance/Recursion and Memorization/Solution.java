import java.util.*;
class Solution{
    public static int f(int index, int[] dp, int[] arr, int k){
        if(index==0){
            return dp[index] = 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int minSteps = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(index-j>=0){
                int jump = f(index-j,dp,arr,k) + Math.abs(arr[index]-arr[index-j]);
                minSteps = Math.min(jump,minSteps);
            }else{
                break;
            }
        }
        return dp[index] = minSteps;
    }
    public static int minimumEnergy(int arr[],int n, int k){
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,dp,arr,k);
    }
    public static void main(String[] args){
        int arr[] = {10,20,30,10};
        int n = 4;
        int k = 2;
        System.out.println(minimumEnergy(arr,n,k));
    }
}
