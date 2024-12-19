import java.util.*;
class Solution{
    public static int maximumPoints(int arr[][], int n) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        for(int day=1; day<n; day++){
            for(int last=0; last<4; last++){
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n-1][3];
    }
    public static void main(String[] args){
        int[][] arr = {{1,2,5},{3,1,1},{3,3,3}};
        System.out.println(maximumPoints(arr,arr.length));
    }
}