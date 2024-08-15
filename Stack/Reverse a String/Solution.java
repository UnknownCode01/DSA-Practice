import java.util.*;
class Solution{
    public static String reverse(String str){
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<str.length()){
            st.push(str.charAt(i));
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String str = "Hello";
        
        System.out.println(reverse(str));
    }
}