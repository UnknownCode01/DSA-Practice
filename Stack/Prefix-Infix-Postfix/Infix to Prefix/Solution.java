import java.util.*;

class Solution {
    static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; // For non-operators or undefined characters
        }
    }

    public static String reverse(String s){
        String ss="";
        int n = s.length();
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i)=='('){
                ss+=')';
            }else if(s.charAt(i)==')'){
                ss+='(';
            }else{
                ss+=s.charAt(i);
            }
        }
        return ss;
    }

    public static String inToPr(String s){
        s = reverse(s);
        String ans ="";
        Stack<Character> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i<n){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                ans+=c;
            }else if(c=='('){
                st.push(c);
            }else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.peek();
                    st.pop();
                }
                st.pop();
            }else{  //Operator
                if(c=='^'){
                    while(!st.isEmpty() && priority(c)<=priority(st.peek())){
                        ans+=st.pop();
                    }
                }else{
                    while(!st.isEmpty() && priority(c)<priority(st.peek())){
                        ans+=st.pop();
                    }
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        ans = reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "a+b-x*(c^d-e)";
        System.out.println(inToPr(s));
    }
}