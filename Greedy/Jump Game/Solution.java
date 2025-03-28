class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (i > total) {
                return false;
            }
            total = Math.max(total, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
    }
}