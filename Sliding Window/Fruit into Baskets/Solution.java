import java.util.*;
class Solution{
    public static int totalFruits(Integer[] arr) {
        int l = 0, r = 0, maxLen = 0;
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans=0;
        while(r<n){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            if(hm.size()>2){
                hm.put(arr[l],hm.getOrDefault(arr[l],0)-1);
                if(hm.get(arr[l])==0){
                    hm.remove(arr[l]);
                }
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
    public static void main(String[] args){
        Integer[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruits(arr));
    }
}