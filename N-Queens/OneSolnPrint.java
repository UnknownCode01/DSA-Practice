class OneSolnPrint{
    //BackTrack
    public static boolean backtrack(char[][] chess, int row){
        if(row==chess.length){
            return true;
        }
        for(int j = 0; j<chess.length; j++){
            if(IsSafe(chess,row,j)){
                chess[row][j]='Q';
                if(backtrack(chess, row+1)){
                    return true;
                }
                chess[row][j]='_';
            }           
        }
        return false;
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

    //Main
    public static void main(String[] args){
        int size = 5;
        char[][] chess = new char[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                chess[i][j]='_';
            }
        }
        if(backtrack(chess,0)){
            print(chess);
        }
        else{
            System.out.println("No solution");
        }
    }
}