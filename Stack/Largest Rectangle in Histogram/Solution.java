import java.util.*;
class Solution{
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int curr = st.pop();
                int next = i;
                int prev = st.isEmpty()?-1:st.peek();
                int area = heights[curr]*(next-prev-1); 
                ans = Math.max(ans,area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int curr = st.pop();
            int next = n;
            int prev = st.isEmpty()?-1:st.peek();
            int area = heights[curr]*(next-prev-1); 
            ans = Math.max(ans,area);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}