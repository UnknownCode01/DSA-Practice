//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are exactly k odd numbers on it.
/*Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:
Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
*/
class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0, count = 0;
        for (int l = 0, r = 0; r < nums.length; r++){
            if (nums[r] % 2 == 1){
                k--;
                count = 0;
            }
            while (k == 0){
                count++;
                k += (nums[l++] % 2);
            }
            res += count;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubarrays(nums,k));
    }
}