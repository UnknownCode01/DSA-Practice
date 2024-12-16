import java.util.*;
import java.time.*;
class Solution{
    public static int fibonacchi1(int n){
        int[] nums = new int[n+1];
        nums[0]=0;
        nums[1]=1;
        for(int i=2;i<=n;i++){
            nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }
    public static void main(String[] args){
        int n = 6;
        // LocalTime myObj1 = LocalTime.now();
        int ans1 = fibonacchi1(n);
        // LocalTime myObj2 = LocalTime.now();
        System.out.println(ans1);
        // Duration duration1 = Duration.between(myObj1, myObj2);
        // System.out.println("Time taken 1 = " + duration1.toMillis() + " ms");
    }
}