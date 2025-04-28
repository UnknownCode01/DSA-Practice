import java.util.*;

class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] arr) {
        int[] nextGreater = new int[arr.length];
        int[] ans = new int[nums1.length];
        Set<Integer> st = new HashSet<>();
        for (int i : nums1) {
            st.add(i);
        }
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
                if (st.contains(arr[i])) {
                    for (int j = 0; j < nums1.length; j++) {
                        if (nums1[j] == arr[i]) {
                            ans[j] = -1;
                        }
                    }
                }
            } else {
                nextGreater[i] = s.peek();
                if (st.contains(arr[i])) {
                    for (int j = 0; j < nums1.length; j++) {
                        if (nums1[j] == arr[i]) {
                            ans[j] = s.peek();
                        }
                    }
                }
            }
            s.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2 };
        int[] nums1 = { 4, 1, 2 };
        int ans[] = nextGreaterElement(nums1, arr);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}