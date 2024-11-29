import java.util.*;
class Solution {
    public static int removeDuplicates(int[] nums) {
        int i=0,j=0,count=0,n=nums.length,k=0;
        int[] ans = new int[n];

        while(j<n){
            if(nums[j]==nums[i]){
                count++;
            }else{
                i=j;
                count=1;
            }
            if(count<=2){
                ans[k++]=nums[j];
            }
            j++;
        }
        System.out.println(k);
        for(i=0;i<ans.length;i++){
            nums[i]=ans[i];
        }
        return k;
    }
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int n = removeDuplicates(nums);
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.println(i+" "+nums[i]);
        }
    }
}