class Solution{
    public static int f(int m, int n, int[][] grid, int[][] dp) {
        if(m==0 && n==0){
            return grid[m][n];
        }
        if(m<0 || n<0){
            return 1000000000;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int left = grid[m][n]+f(m,n-1,grid,dp);
        int up = grid[m][n]+f(m-1,n,grid,dp);
        return dp[m][n]=Math.min(left,up);
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        int ans = f(m-1,n-1,grid,dp);
        return ans;
    }
    public static void main(String[] args){
        int[][] grid ={{1,4,8,6,2,2,1,7},{4,7,3,1,4,5,5,1},{8,8,2,1,1,8,0,1},{8,9,2,9,8,0,8,9},{5,7,5,7,1,8,5,5},{7,0,9,4,5,6,5,6},{4,9,9,7,9,1,9,0}};
        System.out.println(minPathSum(grid));
    }
}