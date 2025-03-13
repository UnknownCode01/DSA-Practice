class Solution{
    public static int knapSack(int[] val, int[] wt, int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1]; //n->no of items    W->capacity
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w<=j){   //include
                    //take
                    int ans1 = v + dp[i][j-w]; //j-w -> remainder weight 
                    //not take
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1,ans2);
                }else{  //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args){
        int[] val = {6, 1, 7, 7};
        int[] wt = {1, 3, 4, 5};
        int W = 8;  // Capacity
        System.out.println(knapSack(val,wt,W));

    }
}