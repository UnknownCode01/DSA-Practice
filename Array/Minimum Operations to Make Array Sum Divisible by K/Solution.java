class Solution {
    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int prev = sum % k;
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 9, 7 };
        int k = 5;
        System.out.println(minOperations(nums, k));
    }
}