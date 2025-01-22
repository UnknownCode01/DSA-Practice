
class Solution{
    public static int func(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = 0;
        int count = 0;
        while (r<nums.length) {
            count+=nums[r]%2;
            while(count>k){
                count-=nums[l]%2;
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }
    public static void main(String[] args){
        int[] nums = {2,1,1,1};
        int k = 2;
        System.out.println(numberOfSubarrays(nums,k));
    }
}