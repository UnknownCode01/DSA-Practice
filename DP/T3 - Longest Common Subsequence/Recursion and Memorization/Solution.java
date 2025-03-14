import java.util.*;

class Solution {
    public static int lcsHelper(String text1, String text2, int n, int m, int[][] dp) {
        if (n < 0 || m < 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (text1.charAt(n) == text2.charAt(m)) {
            return dp[n][m] = 1 + lcsHelper(text1, text2, n - 1, m - 1, dp);
        } else {
            int choice1 = lcsHelper(text1, text2, n - 1, m, dp);
            int choice2 = lcsHelper(text1, text2, n, m - 1, dp);
            return dp[n][m] = Math.max(choice1, choice2);
        }
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return lcsHelper(text1, text2, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}