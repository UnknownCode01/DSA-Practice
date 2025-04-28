import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static int[] printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int temp = 1 + dp[j];
                    if (temp > dp[i]) {
                        dp[i] = temp;
                        parent[i] = j;
                    }
                }
            }
        }
        int maxi = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxi) {
                maxi = dp[i];
                start = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(start!=-1){
            ans.add(nums[start]);
            start = parent[start];
        }
        Collections.reverse(ans);
        // return ans.toArray(new Integer[ans.size()]); ->return type Integer
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        // Integer[] LIS = printLIS(nums);
        int[] LIS = printLIS(nums);
        for (int i : LIS) {
            System.out.print(i + " ");
        }
    }
}