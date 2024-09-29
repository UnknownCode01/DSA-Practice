class NoCon1{
    public static void f(int n,int prev, StringBuilder sb){
        if(n==0){
            System.out.println(sb);
            return;
        }
        if(prev==0){
            f(n-1,0,sb.append("0"));
            sb.deleteCharAt(sb.length()-1);
            f(n-1,1,sb.append("1"));
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            f(n-1,0,sb.append("0"));
            sb.deleteCharAt(sb.length()-1);
        }
    
    }
    public static void main(String[] args){
        f(3,0,new StringBuilder(""));
    }
}