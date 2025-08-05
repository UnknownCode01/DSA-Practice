class Solution {
    public static void f(int n) {
        int m = 2*n-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                int diffLeft=j;
                int diffRight=m-j-1;
                int diffTop=i;
                int diffBottom=m-i-1;
                int ans = Math.min(Math.min(diffLeft,diffRight),Math.min(diffTop,diffBottom));
                System.out.print(ans+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        f(n);
    }
}