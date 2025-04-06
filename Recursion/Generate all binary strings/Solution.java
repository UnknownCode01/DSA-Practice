import java.util.*;

class Solution {
    public static void f(int n, int prev, int size, List<String> ans, StringBuilder curr) {
        if (size == n) {
            ans.add(curr.toString());
            return;
        }
        
        curr.append('0');
        f(n, 0, size + 1, ans, curr);
        curr.deleteCharAt(curr.length() - 1);
        
        if (prev == 0) {
            curr.append('1');
            f(n, 1, size + 1, ans, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        f(n, 0, 1, ans, new StringBuilder("0"));
        f(n, 1, 1, ans, new StringBuilder("1"));
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = generateBinaryStrings(3);
        System.out.println(ans);
    }
}
