class Solution {
    public static int f(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (matrix[start][end] == 1) {
                start++;
            } else if (matrix[end][start] == 1) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        if (start > end) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if(i==start){
                continue;
            }
            if (matrix[start][i] == 0 && matrix[i][start] == 1) {
                continue;
            } else {
                return -1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[][] m1 = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] m2 = { { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(f(m1));
        System.out.println(f(m2));
    }
}