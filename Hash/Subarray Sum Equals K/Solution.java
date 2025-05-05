import java.util.*;

class Solution {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        int prefixSum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i : nums) {
            prefixSum += i;
            if (hm.containsKey(prefixSum - k)) {
                ans += hm.get(prefixSum - k);
            }
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        System.out.println(subarraySum(nums, 3));
    }
}