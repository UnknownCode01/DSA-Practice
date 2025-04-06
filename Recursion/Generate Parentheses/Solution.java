import java.util.*;

class Solution {
    public static void f(List<String> ans, int n, int open, int close, String s) {
        if(open==close && open+close == 2*n){
            ans.add(s);
            return;
        }
        if(open<n){
            f(ans, n, open+1, close, s+"(");
        }
        if(open>close){
            f(ans, n, open, close+1, s+")");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        f(ans, n, open, close, "");
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        System.out.println(ans);
    }
}