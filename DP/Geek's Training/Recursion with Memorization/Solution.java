import java.util.*;
class Solution{
    public static int f(int day, int last, int[][] arr, int[][] dp) {
        if(day==0){
            int maxi = 0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    int points = arr[0][i];
                    maxi = Math.max(maxi,points);
                }
            }
            return dp[day][last] = maxi;
        }
        if(dp[day][last]!=0){
            return dp[day][last];
        }
        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int points = arr[day][i] + f(day-1,i,arr,dp);
                maxi = Math.max(maxi,points);
            }
        }
        return dp[day][last] = maxi;
    }
    public static int maximumPoints(int arr[][], int n) {
        int[][] dp = new int[n][4];
        return f(n-1,3,arr,dp);
    }
    public static void main(String[] args){
        int[][] arr = {{1,2,5},{3,1,1},{3,3,3}};
        System.out.println(maximumPoints(arr,arr.length));
    }
}