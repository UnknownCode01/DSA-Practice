import java.util.*;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int ans = target;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // System.out.println("sum : " + sum);
                int dis = Math.abs(sum - target);
                if(dis<mini){
                    mini = dis;
                    ans = sum;
                }
                // System.out.println("mini: " + mini);
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, 4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}