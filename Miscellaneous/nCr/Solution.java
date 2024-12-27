class Solution{
    public static int nCr(int N, int r){
        double res = 1;
        r = Math.min(r,N-r);
        // System.out.println(r);
        for(int i=1;i<=r;i++){
            res = res *(N-r+i)/i;
        }
        return (int)res;
    }
    public static void main(String[] args){
        int N = 10;
        int r = 7;
        System.out.println(nCr(N,r));
    }
}