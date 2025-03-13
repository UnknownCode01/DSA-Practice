class Solution{
    public static int cutRod(int[] price){
        int n = price.length;
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = i + 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int v = price[i-1];
                int L = l[i-1];
                if(L<=j){   //include
                    //take
                    int ans1 = v + dp[i][j-L]; //j-w -> remainder weight 
                    //not take
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1,ans2);
                }else{  //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args){
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(cutRod(price));

    }
}