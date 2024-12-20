// Space Optimized
import java.util.*;
class Solution{
    public static int rob(int[] nums) {
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
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}