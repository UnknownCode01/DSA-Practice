import java.util.*;

class Solution {
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

    public static int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixMatrix = new int[n][m];
        int[] sum = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    sum[j] = 0;
                    prefixMatrix[i][j] = 0;
                } else {
                    sum[j] += 1;
                    prefixMatrix[i][j] = sum[j];
                }
            }
            ans = Math.max(ans, largestRectangleArea(prefixMatrix[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '1' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println(maximalRectangle(matrix));
    }
}