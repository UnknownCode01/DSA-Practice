import java.util.*;
class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        i = i-1;
        int ithBit = (num>>i)&1;
        int numWithSetBit =( num | (1<<i));
        int clearIthBit = (num & ~(1<<i));
        System.out.print(ithBit+" "+numWithSetBit+" "+clearIthBit);
    }
    
    public static void main(String[] args){
        int num = 70;
        int i = 3;
        bitManipulation(num,i);
    }
}
