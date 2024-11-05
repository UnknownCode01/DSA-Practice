import java.util.*;
class Solution{
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};         //-4, -1, -1, 0, 1, 2
        System.out.println(threeSum(nums));
        nums = new int[]{-1, 0, 5, 7, -1, -4};  //-4, -1, -1, 0, 5, 7 
        System.out.println(threeSum(nums));
    }
}
