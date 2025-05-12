import java.util.*;

class Solution {
    public static long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        Queue<Integer> queue = new LinkedList<>();
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                queue.offer(i);
            }

            if (queue.size() < k){
                continue;
            }
            if (queue.size() > k){
                queue.poll();
            }

            result += queue.peek() + 1;
            // System.out.println(i+"->"+result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println(countSubarrays(nums, k));
    }
}