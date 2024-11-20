import java.util.*;
class Solution {
    static class Pair{
        int row;
        int col;
        int tm;
        Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
    public static int orangesRotting(int[][] grid) {
        int n = grid.length; // row
        int m = grid[0].length; // col
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int tm = 0;
        int cnt = 0;
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+delRow[i];
                int ncol = c+delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    cnt++;
                    vis[nrow][ncol]=2;
                }
            }
        }
        if(cnt!=fresh){
            return -1;
        }
        return tm;
    }
    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}