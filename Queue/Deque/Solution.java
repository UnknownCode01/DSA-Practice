import java.util.*;
class Solution{
    public static void main(String[] args){
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(0);
        dq.addLast(2);
        dq.addLast(3);
        System.out.println(dq);
        dq.removeFirst();
        System.out.println(dq);
        dq.removeLast();
        System.out.println(dq);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
    }
}