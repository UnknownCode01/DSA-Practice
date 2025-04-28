class Solution {
    public static boolean isPalindrome(String s, int i, int j) {
        String sub = s.substring(i, j + 1);
        StringBuilder sb = new StringBuilder(sub);
        return sub.equals(sb.reverse().toString());
    }

    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int mini = Integer.MAX_VALUE;
            for (int index = i; index < s.length(); index++) {
                if (isPalindrome(s, i, index)) {
                    int temp = 1 + dp[index + 1];
                    mini = Math.min(mini, temp);
                }
            }
            dp[i] = mini;
        }

        return dp[0] - 1;
    }

    public static void main(String[] args) {
        String s = "nitin";
        System.out.println(minCut(s));
    }
}