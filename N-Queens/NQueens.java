class NQueens{
    //BackTrack
    public static void backtrack(char[][] chess, int row){
        if(row==chess.length){
            count++;
            print(chess);
            return;
        }
        for(int j = 0; j<chess.length; j++){
            if(IsSafe(chess,row,j)){
                chess[row][j]='Q';
                backtrack(chess, row+1);
                chess[row][j]='_';
            }           
        }
    }
    //Condition
    public static boolean IsSafe(char[][] chess, int row, int col){
        //Up
        for(int i = row-1; i>=0;i--){
            if(chess[i][col]=='Q'){
                return false;
            }
        }
        //Left Diagonal
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--,j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        //Right Diagonal
        for(int i = row-1, j = col+1; i>=0 && j<chess.length; i--,j++){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    //Print
    public static void print(char[][] chess){
        int n = chess.length;
        System.out.println("------Board------");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int count = 0;
    //Main
    public static void main(String[] args){
        int size = 4;
        char[][] chess = new char[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                chess[i][j]='_';
            }
        }
        backtrack(chess,0);
        System.out.println("Total no of ways : "+count);
    }
}