class Solution {
    public static int findMin(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[l] <= nums[h]) {
                mini=Math.min(mini,nums[l]);
                break;
            } else if (nums[l] <= nums[mid]) {
                mini = Math.min(mini, nums[l]);
                l = mid + 1;
            } else {
                mini = Math.min(mini, nums[mid]);
                h = mid - 1;
            }
        }

        return mini;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums));
    }
}