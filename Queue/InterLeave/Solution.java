import java.util.*;
class Solution{
    public static void InterLeave(Queue<Integer> q){
        int n = q.size();
        n=n/2;
        Queue<Integer> first = new LinkedList<>();

        for(int i=0;i<n;i++){
            first.add(q.remove());
        }
        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }
        
    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        InterLeave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}