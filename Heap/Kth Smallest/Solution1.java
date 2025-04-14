import java.util.*;

class Solution1 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }
        int temp = -1;
        for (int i = 0; i < k; i++) {
            temp = pq.poll();
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}