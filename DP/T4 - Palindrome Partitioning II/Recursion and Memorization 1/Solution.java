import java.util.Arrays;

class Solution{
    public static boolean isPalindrome(String s, int i, int j){
        String sub = s.substring(i, j + 1);             
        StringBuilder sb = new StringBuilder(sub);
        return sub.equals(sb.reverse().toString());
    }
    public static int f(String s, int i, int j, int[][] dp){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int index = i;index<j;index++){
            int temp = 1+f(s,i,index,dp)+f(s,index+1,j,dp);
            mini = Math.min(mini,temp);
        }
        return dp[i][j]=mini;
    }
    public static int minCut(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] i:dp){
            Arrays.fill(i, -1);
        }
        return f(s,0,n-1,dp);
    }
    public static void main(String[] args){
        String s = "nitik";
        System.out.println(minCut(s));
    }
}