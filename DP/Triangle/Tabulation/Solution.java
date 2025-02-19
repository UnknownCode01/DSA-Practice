import java.util.*;
class Solution{
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j = n-1;j>=0;j--){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n-2; i>=0; i--){
            for(int j = i; j>=0; j--){
                int d = triangle.get(i).get(j)+dp[i+1][j];
                int dr = triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j] = Math.min(d,dr);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args){
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        System.out.println(minimumTotal(triangle));
    }
}