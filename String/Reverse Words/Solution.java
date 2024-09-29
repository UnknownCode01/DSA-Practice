import java.util.*;
class Solution {
    public static String reverseWords(String s) {
        s=s.strip();
        s+=" ";
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        int j;
        for(int i=0;i<s.length();i=j){
            j=i;
            while(j<s.length() && s.charAt(j)!=' '){
                j++;
            }
            st.push(s.substring(i,j));
            while(j<s.length() && s.charAt(j)==' '){
                j++;
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        String ans = sb.toString();
        ans = ans.substring(0,ans.length()-1);
        return ans;
    }
    public static void main(String[] args){
        String s1 = "a good   example";
        String s2 = " a nice   evening    ";
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }
}