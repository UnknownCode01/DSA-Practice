class Solution {
    public static int findNumbers2(int[] nums) {
        int count = 0;
        for (int i : nums) {
            int digits = (int) (Math.log10(i)) + 1;
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int findNumbers1(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            String s = Integer.toString(i);
            if (s.length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 123, 24, 4 };
        System.out.println(findNumbers1(nums));
    }
}