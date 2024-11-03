import java.util.*;
class Solution{
    static class Pair implements Comparable<Pair>{
        int idx;
        int val;
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
        @Override
        public int compareTo(Pair p){
            return p.val-this.val;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] res = new int[arr.length-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(i,arr[i]));
        }
        res[0]=pq.peek().val;
        int j=1;
        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx<=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(i,arr[i]));
            res[j++]=pq.peek().val;
        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}