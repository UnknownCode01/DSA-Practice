import java.util.*;
class Solution{
    public static void dfs(int[][] mod, int sr, int sc, int iC, int tC, int[] delRow, int[] delCol, int n, int m){
        if(iC==tC){
            return;
        }
        mod[sr][sc]=tC;
        for(int i=0;i<4;i++){
            int nR = sr+delRow[i];
            int nC = sc+delCol[i];
            if(nR>=0 && nR<n && nC>=0 && nC<m && mod[nR][nC]==iC){
                dfs(mod,nR,nC,iC,tC,delRow,delCol,n,m);
            }
        }

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //shallow copy
        int n = image.length; //row
        int m = image[0].length; //col
        int[][] mod = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mod[i][j]=image[i][j];
            }
        }
        //actual code
        int iColor = mod[sr][sc];
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};
        dfs(mod, sr, sc, iColor, color, delRow, delCol, n, m);
        return mod;
    }
    public static void main(String[] args){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] mod = floodFill(image,1,1,2);

        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(mod[i][j]+" ");
            }
            System.out.println();
        }
    }
}