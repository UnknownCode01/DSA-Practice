import java.util.*;
class Solution{
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<Integer, Integer> entry:hm.entrySet()){
            pq.add(entry);
        }
        for(int i=0;i<k;i++){
            ans[i]=pq.remove().getKey();
        }

        return ans;
    }
    public static void main(String[] args){
        ;
        System.out.println();
    }
}