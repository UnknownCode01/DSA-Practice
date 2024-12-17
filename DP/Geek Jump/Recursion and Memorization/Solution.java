import java.util.*;
class Solution{
    public static int f(int index, int[] dp, int[] arr){
        if(index==0){
            return 0;
        }
        if(index==1){
            return dp[index] = Math.abs(arr[index]-arr[index-1]);
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int left = f(index-1,dp,arr) + Math.abs(arr[index]-arr[index-1]);
        int right = f(index-2,dp,arr) + Math.abs(arr[index]-arr[index-2]);
        return dp[index] = Math.min(left,right);
    }
    public static int minimumEnergy(int arr[],int n){
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,dp,arr);
    }
    public static void main(String[] args){
        int arr[] = {10,20,30,10};
        int n = 4;
        System.out.println(minimumEnergy(arr,n));
    }
}
