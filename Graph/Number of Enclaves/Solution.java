import java.util.*;
class Solution{
    static class Pair{
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        //BFS
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            for(int i=0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }

        }
        //count
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}