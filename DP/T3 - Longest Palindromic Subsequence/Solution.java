class Solution{
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
    public static int longestPalindromeSubseq(String s1) {
        StringBuffer sb = new StringBuffer(s1);
        sb.reverse();
        String s2 = sb.toString();
        return longestCommonSubsequence(s1,s2);
    }
    public static void main(String[] args){
        String  s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}