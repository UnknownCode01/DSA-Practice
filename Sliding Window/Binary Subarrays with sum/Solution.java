class Solution{
    public static int func(int[] nums, int goal) {
        if(goal<0){
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums,goal)-func(nums,goal-1);
    }
    public static void main(String[] args){
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
}