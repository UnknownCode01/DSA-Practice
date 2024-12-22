import java.util.*;

class Solution {
    static class Stack {
        private Queue<Integer> q;

        public Stack() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            q.add(x);
            for (int i = 1; i < q.size(); i++) {
                q.add(q.remove());
            }
        }

        public int pop() {
            return q.remove();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }
}