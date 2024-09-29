import java.util.*;
class Solution {
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int key:nums){
            hm.put(key,0);
        }
        for(int key:nums){
            hm.put(key,hm.get(key)+1);
        }
        int maxi = Collections.max(hm.values());
        int result=0;
        for(int i:hm.values()){
            if(i==maxi){
                result+=i;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums={1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));  
    }
}