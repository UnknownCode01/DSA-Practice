import java.util.*;
import java.time.*;
class Solution{
    public static int fibonacchi1(int n){
        if(n==0 | n==1){
            return n;
        }
        return fibonacchi1(n-1)+fibonacchi1(n-2);
    }
    public static int fibonacchi2(int n, int[] f){
        if(n==0 | n==1){
            return n;
        }
        if(f[n]!=0){
            return n;
        }
        f[n] = fibonacchi1(n-1)+fibonacchi1(n-2);
        return f[n];
    }
    public static void main(String[] args){
        int n = 45;
        LocalTime myObj1 = LocalTime.now();
        int ans1 = fibonacchi1(n);
        LocalTime myObj2 = LocalTime.now();
        System.out.println(ans1);
        Duration duration1 = Duration.between(myObj1, myObj2);
        System.out.println("Time taken 1 = " + duration1.toMillis() + " ms");
        //
        int[] f = new int[n+1];
        LocalTime myObj3 = LocalTime.now();
        int ans2 = fibonacchi2(n, f);
        LocalTime myObj4 = LocalTime.now();
        System.out.println(ans2);
        Duration duration2 = Duration.between(myObj3, myObj4);
        System.out.println("Time taken 2 = " + duration2.toMillis() + " ms");
    }
}