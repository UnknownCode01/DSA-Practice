// formula: 2^{log_2(n)+1}
 
class Solution {
    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int hBit = 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        while ((1 << (hBit + 1)) <= n) {
            hBit++;
        }
        int ans = 1 << (hBit + 1);
        return ans;
    }
    public static int uniqueXorTriplets2(int[] nums) {
        int n = nums.length;
        // When n = 1 or 2, return n
        if (n <= 2) return n;

        // floor(log2(n)) + 1
        int hBit = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;

        // Return 2^hBit
        return 1 << hBit;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        int[] nums2 = { 3,1,2 };
        System.out.println(uniqueXorTriplets(nums));
        System.out.println(uniqueXorTriplets2(nums2));
    }
}