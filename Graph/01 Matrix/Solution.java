import java.util.*;
class Node{
    int f;
    int s;
    int t;
    Node(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}
class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            Node x = q.remove();
            int row = x.f;
            int col = x.s;
            int steps = x.t;
            dis[row][col]=steps;
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return dis;
    }
    public static void main(String[] args){
        int[][] mat ={
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        int[][] dis = updateMatrix(mat);
        for(int i=0;i<dis.length;i++){
            for(int j=0;j<dis[0].length;j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }
    }
}