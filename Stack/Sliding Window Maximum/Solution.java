import java.util.*;
import java.util.LinkedList;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] ans = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.add(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 7,2,4 };
        int k = 2;
        int[] ans = maxSlidingWindow(nums, k);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}