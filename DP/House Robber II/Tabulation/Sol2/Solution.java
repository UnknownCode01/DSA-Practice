// Space Optimized
import java.util.*;
class Solution{
    public static int f(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>=2){
                pick += prev2;
            } 
            int notPick = 0 + prev;
            int curr = Math.max(pick,notPick); 
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0){
                nums1[i-1] = nums[i];
            }
            if(i!=n-1){
                nums2[i] = nums[i];
            }
        }
        int ans1 = f(nums1);
        int ans2 = f(nums2);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args){
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }
}