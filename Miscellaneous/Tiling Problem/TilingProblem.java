class TilingProblem{
    public static int f(int n){    //2xn area with 2x1 tiles
        if(n==0 || n==1){
            return 1;
        }
        int f1=f(n-1);
        int f2=f(n-2);
        return f1+f2;
    }
    public static void main(String[] args){
        int ways = f(5);
        System.out.println(ways);
    }
}