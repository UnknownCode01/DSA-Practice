import java.util.*;
class Solution{
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int bp = -1;   //break point
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                bp = i;
                break;
            }
        }
        if(bp==-1){
            Arrays.sort(nums);
            return;
        }
        for(int i=n-1;i>bp;i--){    //smallest no after breakpoint >nums[bp]
            if(nums[i]>nums[bp]){
                int temp = nums[i];
                nums[i] = nums[bp];
                nums[bp] = temp;
                break;
            }
        }
        int i=bp+1;
        int j=n-1;
        while(i<j){     //next lexicographically greater permutation
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args){
        int[] nums = {3,2,1};
        nextPermutation(nums);
        for(int k=0;k<nums.length;k++){
            System.out.print(nums[k]+" ");
        }
    }
}