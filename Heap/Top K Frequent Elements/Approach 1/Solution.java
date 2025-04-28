import java.util.*;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>(hm.keySet());
        Collections.sort(arr, (a, b) -> hm.get(b) - hm.get(a));
        for (int i = 0; i < k; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}