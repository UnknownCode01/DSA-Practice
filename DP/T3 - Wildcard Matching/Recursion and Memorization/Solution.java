import java.util.Arrays;

class Solution {
    public static boolean f(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i >= 0 && j < 0) {
            return false;
        }
        if (i < 0 && j >= 0) {
            for (int k = j; k >= 0; k--) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = f(s, p, i - 1, j - 1, dp)?1:0;
            return dp[i][j]==1;
        }
        if (p.charAt(j) == '*') {
            dp[i][j] = (f(s, p, i, j - 1, dp) || f(s, p, i - 1, j, dp))?1:0;
            return dp[i][j]==1;
        }
        dp[i][j]=0;
        return dp[i][j]==1;
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s, p, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String s = "aaba";
        String p = "***b?";
        System.out.println(isMatch(s, p));
    }
}