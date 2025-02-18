class Solution{
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }else{
                    int up = 1000000000;
                    int left = 1000000000;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = Math.min(up,left) + grid[i][j];;
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        int[][] grid ={{1,4,8,6,2,2,1,7},{4,7,3,1,4,5,5,1},{8,8,2,1,1,8,0,1},{8,9,2,9,8,0,8,9},{5,7,5,7,1,8,5,5},{7,0,9,4,5,6,5,6},{4,9,9,7,9,1,9,0}};
        System.out.println(minPathSum(grid));
    }
}