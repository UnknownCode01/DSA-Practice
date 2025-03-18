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

    public static int minDistance(String word1, String word2) {
        int ans = 0;
        int lcs = longestCommonSubsequence(word1, word2);
        ans += word1.length() - lcs;// Insertion
        ans += word2.length() - lcs;// Deletion
        return ans;
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }
}