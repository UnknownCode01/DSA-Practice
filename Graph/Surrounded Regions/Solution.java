import java.util.*;

class Solution {
    public static void dfs(int row, int col, char[][] board, int[][] vis){
        vis[row][col]=1;
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        int n = board.length;   //row
        int m = board[0].length;    //col
        for(int i=0;i<4;i++){
            int nrow = row+delr[i];
            int ncol = col+delc[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,vis);
            }
        }
    }
    public static void solve(char[][] board) {
        int n = board.length;   //row
        int m = board[0].length;    //col
        int[][] vis = new int[n][m];
        for(int i=0;i<m;i++){   //row
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,board,vis);
            }
            if(vis[n-1][i]==0 && board[n-1][i]=='O'){
                dfs(n-1,i,board,vis);
            } 
        }
        for(int i=0;i<n;i++){   //col
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,board,vis);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,board,vis);
            } 
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void print(char[][] board){
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        print(board);
        solve(board);
        print(board);
    }
}
