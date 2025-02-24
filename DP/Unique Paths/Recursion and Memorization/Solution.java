class Solution{
    public static int f(int m, int n, int[][] dp) {
        if(m==1 && n==1){
            return 1;
        }
        if(m<1 || n<1){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int left = f(m, n-1, dp);
        int up = f(m-1, n, dp);
        dp[m][n] = left+up;
        return dp[m][n];
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return f(m,n,dp);
    }
    public static void main(String[] args){
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m,n));
    }
}