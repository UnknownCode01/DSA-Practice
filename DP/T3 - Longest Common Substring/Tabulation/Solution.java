class Solution {
    public static int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abca";
        String s2 = "bbcc";
        System.out.println(longestCommonSubstr(s1, s2));
    }
}