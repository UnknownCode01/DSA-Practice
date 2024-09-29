import java.util.*;
class Solution{
    static class Queue{
        Deque<Integer> dq = new LinkedList<>();
        void add(int data){
            dq.addLast(data);
        }
        int remove(){
            return dq.removeFirst();
        }
        int peek(){
            return dq.getFirst();
        }
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek->"+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}