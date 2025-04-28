import java.util.*;

class Solution {
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2*arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i%n] >= s.peek()) {
                s.pop();
            }
            if (i<n) {
                nextGreater[i] = s.isEmpty()?-1:s.peek();
            }
            s.push(arr[i%n]);
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2 };
        int ans[] = nextGreaterElement(arr);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}