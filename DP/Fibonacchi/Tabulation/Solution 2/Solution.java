import java.util.*;
import java.time.*;
class Solution{
    public static int fibonacchi1(int n){
        int prev2=0;
        int prev1=1;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args){
        int n = 6;
        int ans = fibonacchi1(n);
        System.out.println(ans);
    }
}