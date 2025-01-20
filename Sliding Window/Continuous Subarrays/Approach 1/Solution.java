import java.util.*;
class Solution {
    public static long continuousSubarrays(int[] nums) {
        int l = 0;
        int r = 0;
        long count = 0;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        while(r<nums.length){
            tm.put(nums[r],tm.getOrDefault(nums[r],0)+1);
            while(tm.lastEntry().getKey()-tm.firstEntry().getKey()>2){
                tm.put(nums[l],tm.get(nums[l])-1);
                if(tm.get(nums[l])==0){
                    tm.remove(nums[l]);
                }
                l++;
            }
            count+=r-l+1;
            r++;
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,6,3};
        System.out.println(continuousSubarrays(nums));
    }
}
