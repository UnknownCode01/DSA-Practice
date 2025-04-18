class Solution {
    public static String shortestCommonSupersequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String ans = "";
        StringBuilder res = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                ans += s.charAt(i-1);
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                ans += s.charAt(i-1);
                i--;
            } else {
                ans += t.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            ans+=s.charAt(i-1);
            i--;
        }
        while(j>0){
            ans+=t.charAt(j-1);
            j--;
        }
        res.append(ans);
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }
}
