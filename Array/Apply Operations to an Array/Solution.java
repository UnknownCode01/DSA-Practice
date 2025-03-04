class Solution {
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
                i++;
            }
        }
        int k = 0;
        for (int i : nums) {
            if (i != 0) {
                ans[k++] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 1, 0 };
        int[] ans = applyOperations(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}