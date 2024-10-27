import java.util.*;
class Solution{
    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        int target = totalSum % p;
        if (target == 0) {
            return 0; 
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        int currentSum = 0;
        int minLen = n;

        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;
            int needed = (currentSum - target + p) % p;

            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }
            modMap.put(currentSum, i);
        }
        return minLen == n ? -1 : minLen;
    }
    public static void main(String[] args){
        int[] arr = {2,16,16,10,10,6,4,1,8,19};
        int p = 36;
        System.out.println(minSubarray(arr,p));
    }
}
