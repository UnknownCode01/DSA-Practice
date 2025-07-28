class Solution{
    public static void f(int n){
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n;j++){
                System.out.print((char)('A'+j-1));
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        int n = 5;
        f(n);
    }
}