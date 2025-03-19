class Solution {
    public static int f(String s, String t, int n, int m, int[][] dp) {
        if (m == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n][m] != 0) {
            return dp[n][m];
        }
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            dp[n][m] = f(s, t, n - 1, m - 1, dp) + f(s, t, n - 1, m, dp);
        } else {
            dp[n][m] = f(s, t, n - 1, m, dp);
        }
        return dp[n][m];

    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = f(s, t, n, m, dp);
        return ans;
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s, t));
    }
}