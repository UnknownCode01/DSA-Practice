import java.util.*;
class Solution {
    public static int myAtoi(String s) {
        s=s.trim();
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int ans=0;
        int flag=1; //+ve;
        boolean flag2=false;    //first char;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                if(ans>max/10 || (ans==max/10 && c-'0'>max%10)){
                    System.out.println(c+" "+max%10);
                    return flag==1?max:min;
                }
                ans=ans*10+c-'0';
            }else if((c=='-' || c=='+') && i==0){
                if(c=='-'){
                    flag=-1;
                }
            }else{
                break;
            }
        }
        if(flag!=1){
            ans=0-ans;
        }
        return ans;
    }
    public static void main(String[] args){
        String s="2147483646";
        System.out.println(myAtoi(s));
        s="1337c0d3";
        System.out.println(myAtoi(s));
        s="0-1";
        System.out.println(myAtoi(s));
        s="   +0 123";
        System.out.println(myAtoi(s));
        s="words and 987";
        System.out.println(myAtoi(s));
        s="-91283472332";
        System.out.println(myAtoi(s));
    }
}