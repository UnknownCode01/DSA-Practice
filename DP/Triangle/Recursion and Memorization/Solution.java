import java.util.*;
class Solution{
    public static int f(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=0) return dp[i][j];
        int d = triangle.get(i).get(j) + f(i+1, j, triangle, dp);
        int dr = triangle.get(i).get(j) + f(i+1, j+1, triangle, dp);
        return dp[i][j] = Math.min(d,dr);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        return f(0,0,triangle,dp);
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