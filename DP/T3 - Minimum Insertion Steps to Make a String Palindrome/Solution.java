class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int choice1 = dp[i - 1][j];
                    int choice2 = dp[i][j - 1];
                    dp[i][j] = Math.max(choice1, choice2);
                }
            }
        }

        return dp[n][m];
    }

    public static int minInsertions(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        String s2 = sb.toString();
        int lcs = longestCommonSubsequence(s1, s2);
        int ans = s1.length() - lcs;
        return ans;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertions(s));
    }
}