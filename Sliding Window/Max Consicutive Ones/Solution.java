class Solution {
    public static int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int max=0;
        int zero=0;
        while(r<nums.length){
            if(nums[r]==0){
                zero++;
            }
            if(zero>k){
                if(nums[l]==0){
                zero--;
                }
                l++;
            }
            if(zero<=k){
                max=Math.max(max,r-l+1);
            }
            r++;
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
}