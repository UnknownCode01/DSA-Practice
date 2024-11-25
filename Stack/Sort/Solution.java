import java.util.*;
class Solution {
    public static void insert(Stack<Integer> s, int el){
        if(s.isEmpty() || el>=s.peek()){
            s.push(el);
        }else{
            int top = s.pop();
            insert(s,el);
            s.push(top);
        }
    }
    public static Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s;
        }
        int top = s.pop();
        sort(s);
        insert(s,top);
        return s; 
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(5);
        s.push(3);
        s.push(7);
        System.out.println(sort(s));
    }
}
