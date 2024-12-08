import java.util.*;
class Solution{
    public static int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int low = 1, high = nums[nums.length-1],ans=0;
        while (low <= high) {
            int mid = (low + high) / 2;
            // System.out.println(mid);
            int counter = 0;
            for (int i = 0; i < nums.length; i++) {
                int add = (int)Math.ceil((double)nums[i] / (double)mid) - 1;
                counter = counter + add;
            }
            if (counter <= maxOperations) {
                ans = mid;
                // System.out.println(ans);
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {9};
        int maxOperations = 2;
        System.out.println(minimumSize(nums, maxOperations));
    }
}