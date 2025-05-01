import java.util.*;

class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int limiter = nums.length / 3;
        for (Integer x : hm.keySet()) {
            if (hm.get(x) > limiter) {
                ans.add(x);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr));
    }
}