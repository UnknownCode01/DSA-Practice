import java.util.Arrays;

class Solution {
    public static boolean isPalindrome(String s, int i, int j) {
        String sub = s.substring(i, j + 1);
        StringBuilder sb = new StringBuilder(sub);
        return sub.equals(sb.reverse().toString());
    }

    public static int f(String s, int i, int[] dp) {
        if (i == s.length()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int mini = Integer.MAX_VALUE;
        for (int index = i; index < s.length(); index++) {
            if (isPalindrome(s, i, index)) {
                int temp = 1 + f(s, index + 1, dp);
                mini = Math.min(mini, temp);
            }
        }
        return dp[i] = mini;
    }

    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(s, 0, dp)-1;
    }

    public static void main(String[] args) {
        String s = "nitik";
        System.out.println(minCut(s));
    }
}