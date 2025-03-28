class Solution {
    public static int jump(int[] nums) {
        int n = nums.length;
        int s = 0, e = 0;
        int jumps = 0;
        while (e < n - 1) {
            jumps++;
            int farthest = 0;
            for(int i=s;i<=e;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            s = e + 1;
            e = farthest;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,1,1,1 };
        System.out.println(jump(nums));
    }
}