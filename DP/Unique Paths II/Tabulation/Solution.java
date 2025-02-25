class Solution{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0 && j==0){
                    dp[i][j] = 1;
                }else{
                    int left = 0;
                    int up = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = left+up;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        int[][] obstacleGrid = new int[m][n];
        obstacleGrid[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}