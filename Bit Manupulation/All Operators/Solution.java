import java.util.*;
class Solution{
    public static int and(int a, int b){
        int x = 0;
        x=a&b;
        return x;
    }
    public static int or(int a, int b){
        int x = 0;
        x=a|b;
        return x;
    }
    public static int xor(int a, int b){
        int x = 0;
        x=a^b;
        return x;
    }
    public static int not(int a){
        int x = 0;
        x=~a;
        return x;
    }
    public static int shift(int a, int b){
        int x = 0;
        x=a<<b;
        return x;
    }
    public static void main(String[] args){
        int a=5,b=3;    //a='101'   b='011'
        System.out.println(and(a,b));
        System.out.println(or(a,b));
        System.out.println(xor(a,b));
        System.out.println(not(a));
        System.out.println(shift(a,b));
        // System.out.println();
    }
}