class Solution {
    public static boolean isPalindrome(String s, int i, int j) {
        String sub = s.substring(i, j + 1);
        StringBuilder sb = new StringBuilder(sub);
        return sub.equals(sb.reverse().toString());
    }

    public static int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    continue;
                }
                if (isPalindrome(s, i, j)) {
                    continue;
                }
                int mini = Integer.MAX_VALUE;
                for (int index = i; index < j; index++) {
                    int temp = 1 + dp[i][index] + dp[index + 1][j];
                    mini = Math.min(mini, temp);
                }
                dp[i][j] = mini;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "nitin";
        System.out.println(minCut(s));
    }
}