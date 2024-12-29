import java.util.*;
class Solution {
    static boolean checkKthBit(int n, int k) {
        return (n>>k&1)==1;
    }
    public static void main(String[] args){
        int n = 5;
        int k = 0;
        System.out.println(checkKthBit(n,k));
        System.out.println(checkKthBit(n,k+1));
    }
}
