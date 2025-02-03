import java.util.*;
class Solution{
    public static int f(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l = 0; 
        int r = 0;
        int count = 0;
        while(r<nums.length){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while (hm.size()>k) {
                hm.put(nums[l],hm.getOrDefault(nums[l],0)-1);
                if(hm.get(nums[l])==0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int ans = f(nums, k)-f(nums, k-1);
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {1,2,1,3,4};
        int k = 3;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}