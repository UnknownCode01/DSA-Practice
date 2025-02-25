class Solution{
    public static int f(int m, int n, int[][] dp, int[][] obstacleGrid) {
        // System.out.println(m+" "+n);
        if(m>=0 && n>=0 && obstacleGrid[m][n] == 1){
            return 0;
        }
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int left = f(m, n-1, dp, obstacleGrid);
        int up = f(m-1, n, dp, obstacleGrid);
        dp[m][n] = left+up;
        return dp[m][n];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(m-1,n-1,dp,obstacleGrid);
    }
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        int[][] obstacleGrid = new int[m][n];
        obstacleGrid[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}