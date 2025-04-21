import java.util.ArrayList;
import java.util.List;

class Solution{
    public static List<Integer> spiralOrder(int[][] matrix){
        int m=matrix.length;    //matrix[m][n]-> sr: Starting Row, er: Ending Row, sc: Starting Column, ec: Ending Column
        int n=matrix[0].length;
        int sr=0;
        int er=m-1;
        int sc=0;
        int ec=n-1;
        List<Integer> ans = new ArrayList<>();
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                ans.add(matrix[sr][i]);
            }
            for(int i=sr+1;i<=er;i++){
                ans.add(matrix[i][ec]);
            }
            for(int i=ec-1;i>=sc;i--){
                if(sr==er){
                    break;
                }
                ans.add(matrix[er][i]);
            }
            for(int i=er-1;i>sr;i--){
                if(sc==ec){
                    break;
                }
                ans.add(matrix[i][sc]);
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] matrix={
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15}
        };
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}