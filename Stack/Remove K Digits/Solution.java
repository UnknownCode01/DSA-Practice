import java.util.*;

class Solution {
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) {
            return "0";
        }
        String ans = "";
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = num.charAt(i)-'0';
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k>0 && arr[i]<st.peek()) {
               st.pop();
               k--;
            }
            st.push(arr[i]);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        // for(int i:st){
        //     System.out.print(i+" ");
        // }
        while (!st.isEmpty() && st.get(0) == 0) {
            st.remove(0);
        }
        if (st.isEmpty()) {
            return "0";
        }
        for (int i : st) {
            ans+=(char) (i+'0');
        }
        return ans;
    }

    public static void main(String[] args) {
        String num = "100200";
        int k = 1;
        String ans = removeKdigits(num, k);
        System.out.println(ans);
    }
}