import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] ropes = {2,3,3,4,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int x = pq.remove();
            int y = pq.remove();
            cost+=x+y;
            pq.add(x+y);
        }
        System.out.println(cost);
    }
}