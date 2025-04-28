import java.util.Arrays;

class Solution {
    public static int jump(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
                if (j == n - 1) {
                    for(int k=0;k<n;k++){
                        System.out.print(dp[k]+" ");
                    }
                    return dp[n - 1];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2,3,1,1,4 };
        System.out.println("\n"+jump(nums));
    }
}