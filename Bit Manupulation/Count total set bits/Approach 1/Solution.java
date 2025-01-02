class Solution{
    public static int countSetBits(int n){
        int ans = 0;
        for(int x=n;x>0;x--){
            int i=x;
            while(i>0){
                ans += i&1;
                i = i>>1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(countSetBits(17));
    }
}
