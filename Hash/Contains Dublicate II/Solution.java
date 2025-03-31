import java.util.*;

class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(nums[i]) && i - hm.get(nums[i]) <= k) {
                return true;
            }
            hm.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}