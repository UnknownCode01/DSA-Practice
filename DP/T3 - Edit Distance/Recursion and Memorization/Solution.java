import java.util.*;

class Solution {
    public static int f(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return f(word1, word2, i - 1, j - 1, dp);
        } else {
            int insert = 1 + f(word1, word2, i, j - 1, dp);
            int delete = 1 + f(word1, word2, i - 1, j, dp);
            int replace = 1 + f(word1, word2, i - 1, j - 1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        return f(word1, word2, n, m, dp);
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}