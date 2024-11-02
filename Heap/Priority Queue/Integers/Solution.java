import java.util.*;
class Solution{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(1);
        pq.add(0);
        pq.add(2);
        pq.add(5);
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
        System.out.println();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(3);
        pq2.add(1);
        pq2.add(0);
        pq2.add(2);
        pq2.add(5);
        System.out.println(pq2);
        while(!pq2.isEmpty()){
            System.out.print(pq2.peek()+" ");
            pq2.remove();
        }
        System.out.println();
    }
}   