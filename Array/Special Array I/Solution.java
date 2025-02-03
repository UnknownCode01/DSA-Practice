class Solution{
    public static boolean check(int[] nums, int i, int j) {
        if(nums[i]%2==0 && nums[j]%2==0)    return false;
        if(nums[i]%2!=0 && nums[j]%2!=0)    return false;
        return true;
    }
    public static boolean isArraySpecial(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(!check(nums,i,i+1))  return false;
        }
        return true;
    }
    public static void main(String[] args){
        int[] nums = {1};
        System.out.println(isArraySpecial(nums));
    }
}