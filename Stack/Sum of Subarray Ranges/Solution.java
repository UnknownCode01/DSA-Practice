import java.util.*;

class Solution {
    public static long sumSubarrayRanges(int[] A) {
        int n = A.length, j, k;
        long res = 0;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long) A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }

        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long) A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 }; // ans->4
        long ans = sumSubarrayRanges(arr);
        System.out.println(ans);
    }
}