import java.util.*;
class Solution {
    public static long continuousSubarrays(int[] nums) {
        int left = 0, right = 0;
        long count = 0; // Total count of valid subarrays

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);

        while (right < nums.length) {
            minHeap.add(right);
            maxHeap.add(right);

            while (left < right && nums[maxHeap.peek()] - nums[minHeap.peek()] > 2) {
                // System.out.println(maxHeap.peek()+" "+minHeap.peek());
                // System.out.println(nums[maxHeap.peek()] +" "+ nums[minHeap.peek()]);
                left++;

                while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek() < left) {
                    minHeap.poll();
                }
            }

            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,6,3};
        System.out.println(continuousSubarrays(nums));
    }
}
