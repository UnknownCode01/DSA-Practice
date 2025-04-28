import java.util.*;

class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (asteroids[i] >= 0) {
                st.push(asteroids[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==-asteroids[i]){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[st.size()];
        int x = 0;
        for(int i:st){
            ans[x++]=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = { 5, -10, 5, -4, -6, 10, -9 };
        int[] ans = asteroidCollision(asteroids);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}