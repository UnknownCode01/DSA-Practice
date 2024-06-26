// Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

// Example 1:

// Input: nums = [8,2,4,7], limit = 4
// Output: 2 

// Example 2:

// Input: nums = [10,1,2,4,7,2], limit = 5
// Output: 4 
// Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.

// Example 3:

// Input: nums = [4,2,2,2,4,4,2,2], limit = 0
// Output: 3

class Solution {
    public static int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        int diff=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int min=nums[i],max=nums[i];
            for(int j=i;j<n;j++){
                    if(nums[j]>max) max=nums[j];
                    if(nums[j]<min) min=nums[j];
                    if(max-min<=limit){
                        diff=j-i+1;
                        System.out.println("i="+i+" j="+j+" max="+max+" min="+min+" diff="+diff);
                        ans=Math.max(ans,diff);
                    }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={8,2,4,7};
        int limit=4;
        System.out.println(longestSubarray(nums,limit));
    }
}