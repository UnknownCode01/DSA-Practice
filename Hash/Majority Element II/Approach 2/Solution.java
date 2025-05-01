import java.util.*;

class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        int c1 = 0;
        int c2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (c1 == 0 && e2 != nums[i]) {
                c1 = 1;
                e1 = nums[i];
            } else if (c2 == 0 && e1 != nums[i]) {
                c2 = 1;
                e2 = nums[i];
            } else if (nums[i] == e1) {
                c1++;
            } else if (nums[i] == e2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        int limiter = n / 3;
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (e1 == nums[i]) {
                c1++;
            } else if (e2 == nums[i]) {
                c2++;
            }
        }
        if (c1 > limiter) {
            ans.add(e1);
        }
        if (c2 > limiter) {
            ans.add(e2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 1, 3, 9, 2, 2, 1 };
        System.out.println(majorityElement(arr));
    }
}