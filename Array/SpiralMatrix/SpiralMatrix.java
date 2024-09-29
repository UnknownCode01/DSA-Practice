class SpiralMatrix{
    public static void printSpiralMatrix(int[][] matrix){
        int m=matrix.length;    //matrix[m][n]-> sr: Starting Row, er: Ending Row, sc: Starting Column, ec: Ending Column
        int n=matrix[0].length;
        int sr=0;
        int er=m-1;
        int sc=0;
        int ec=n-1;
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                System.out.print(matrix[sr][i]+" ");
            }
            for(int i=sr+1;i<=er;i++){
                System.out.print(matrix[i][ec]+" ");
            }
            for(int i=ec-1;i>=sc;i--){
                if(sr==er){
                    break;
                }
                System.out.print(matrix[er][i]+" ");
            }
            for(int i=er-1;i>sr;i--){
                if(sc==ec){
                    break;
                }
                System.out.print(matrix[i][sc]+" ");
            }
            sr++;
            er--;
            sc++;
            ec--;
        }

    }
    public static void main(String[] args){
        int[][] matrix={
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15}
        };
        printSpiralMatrix(matrix);
    }
}