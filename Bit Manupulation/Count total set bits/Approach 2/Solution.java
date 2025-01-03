import java.util.*;
class Solution{
    public static int countSetBits(int n){
        int ans = 0;
        for(int x=n;x>0;x--){
            int i=x;
            while(i>0){
                i=i&(i-1);
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(countSetBits(17));
    }
}
