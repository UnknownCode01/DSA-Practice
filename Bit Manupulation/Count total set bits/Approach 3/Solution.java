import java.util.*;
class Solution{
    public static int countSetBits(int n){

        int count = 0;
        int x = 1;
        
        while (x <= n) {
            int completeGroups = n / (x * 2);
            count += completeGroups * x;
            int remainder = n % (x * 2);
            count += Math.max(0, remainder - x + 1);
            x <<= 1;
        }
        
        return count;
    }
    public static void main(String[] args){
        System.out.println(countSetBits(17));
    }
}
