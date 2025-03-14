import java.util.*;

class Solution {
    public static int lcsHelper(String text1, String text2, int n, int m, int[][] dp, int[] ans) {
        // ans[0]++; //count for Overflow check
        if (n < 0 || m < 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (text1.charAt(n) == text2.charAt(m)) {
            dp[n][m] = 1 + lcsHelper(text1, text2, n - 1, m - 1, dp, ans);
            ans[0] = Math.max(ans[0], dp[n][m]);
            return dp[n][m];
        } else {
            dp[n][m] = 0;
            lcsHelper(text1, text2, n - 1, m, dp, ans); // Explore other possibilities
            lcsHelper(text1, text2, n, m - 1, dp, ans);
            return 0;
        }
    }

    public static int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int[] ans = new int[1];
        lcsHelper(s1, s2, n - 1, m - 1, dp, ans);
        return ans[0]; // Stack Overflow
    }

    public static void main(String[] args) {
        // Stack Overflow
        // String text1 = "KXCGMTMVVGFQQWSPD";
        // String text2 =
        // "JXZADDUKVLQPKUZJZHWSUTPCAFSYAIBJHAMMEGWBTPQELRNKBLDXGUZGCSEC";
        String text1 = "abca";
        String text2 = "bbcc";

        System.out.println(longestCommonSubstr(text1, text2));
    }
}