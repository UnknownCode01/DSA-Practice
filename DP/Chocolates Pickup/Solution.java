import java.util.Arrays;

class Solution {
    public static int f(int i, int j1, int j2, int r, int c, int grid[][], int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return -100000000;
        }
        if (i == r - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int val = 0;
                if (j1 == j2) {
                    val = grid[i][j1];
                } else {
                    val = grid[i][j1] + grid[i][j2];
                }
                val += f(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
                maxi = Math.max(maxi, val);
            }

        }
        return dp[i][j1][j2] = maxi;
    }

    public static int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 0, m - 1, n, m, grid, dp);
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        int grid[][] = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println(solve(n, m, grid));
    }
}