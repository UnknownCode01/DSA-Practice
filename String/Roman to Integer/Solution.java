import java.util.*;
class Solution{
    public static int romanToInt(String s) {
        char[] arr = new char[s.length()]; 
        arr = s.toCharArray();
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(i+1<arr.length && f(arr[i])<f(arr[i+1])){
                ans+=f(arr[i+1])-f(arr[i]);
                i++;
            }else{
                ans+=f(arr[i]);
            }
        }
        return ans;
    }
    public static int f(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
    public static void main(String[] args){
        String s ="LVIII";
        System.out.println(romanToInt(s));
    }
}