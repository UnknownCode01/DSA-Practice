class Solution{
    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0, count = 0;
        int l = 0;
        int r = 0;
        while( r < nums.length){
            if (nums[r] % 2 == 1){
                k--;
                count = 0;
            }
            while (k == 0){
                count++;
                k += (nums[l++] % 2);
            }
            res += count;
            r++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {2,2,1,1,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums,k));
    }
}