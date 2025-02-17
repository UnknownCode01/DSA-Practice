class Solution{
    public static int f(int[][] matrix, int i, int j, int n, int m, int[][] dp) {
        if(j<0 || j>=m) return Integer.MAX_VALUE;
        if(i==0)  return matrix[i][j];
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        long u = (long)matrix[i][j] + (long)f(matrix, i-1, j, n, m, dp);
        long ul = (long)matrix[i][j] + (long)f(matrix, i-1, j-1, n, m, dp);
        long ur = (long)matrix[i][j] + (long)f(matrix, i-1, j+1, n, m, dp);
        // System.out.println(u+" "+ul+" "+ur);
        return dp[i][j] = (int) Math.min(u,Math.min(ul,ur));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = Integer.MAX_VALUE;
        for(int j=m-1;j>=0;j--){
            ans = Math.min(ans,f(matrix,n-1,j,n,m,dp));
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}