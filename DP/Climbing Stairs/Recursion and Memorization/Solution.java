import java.util.*;
class Solution{
    public static int climbingStairs1(int n){   //with recursion only
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbingStairs1(n-1)+climbingStairs1(n-2);
    }
    public static int climbingStairs2(int n, int[] ways){   //with recursion and memorization
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){
            return ways[n];
        }
        ways[n] = climbingStairs2(n-1, ways)+climbingStairs2(n-2, ways);
        return ways[n];
    }
    public static void main(String[] args){
        int n = 5;
        System.out.println(climbingStairs1(n));
        int[] ways = new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(climbingStairs2(n,ways));
    }
}