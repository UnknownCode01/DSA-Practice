class NoCon1_String{
    public static void f(int n,int prev, String sb){
        if(n==0){
            System.out.println(sb);
            return;
        }
        if(prev==0){
            f(n-1,0,sb+"0");
            f(n-1,1,sb+"1");
        }
        else{
            f(n-1,0,sb+"0");
        }
    
    }
    public static void main(String[] args){
        f(4,0,"");
    }
}