import java.util.*;

class Solution {
    public static int maxLen(int arr[]) {
        int n = arr.length;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                ans = Math.max(ans, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(arr));
    }
}