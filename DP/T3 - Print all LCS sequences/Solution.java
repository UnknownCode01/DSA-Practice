import java.util.*;

class Solution {
    public static List<String> all_longest_common_subsequences(String s, String t) {
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

        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        backtrack(dp, s, t, n, m, "", set, map);
        List<String> lst = new ArrayList<>(set);
        Collections.sort(lst);
        return lst;
    }

    public static void backtrack(int[][] dp, String s, String t, int i, int j, String lcs, Set<String> res,
            Map<String, List<String>> memo) {
        if (i == 0 || j == 0) {
            res.add(new StringBuilder(lcs).reverse().toString());
            return;
        }

        String key = i + "," + j + "," + lcs;

        if (memo.containsKey(key)) {
            res.addAll(memo.get(key));
            return;
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            backtrack(dp, s, t, i - 1, j - 1, lcs + s.charAt(i - 1), res, memo);
        } else {
            if (dp[i - 1][j] == dp[i][j]) {
                backtrack(dp, s, t, i - 1, j, lcs, res, memo);
            }
            if (dp[i][j - 1] == dp[i][j]) {
                backtrack(dp, s, t, i, j - 1, lcs, res, memo);
            }
        }

        List<String> lst = new ArrayList<>(res);
        memo.put(key, lst);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aecbe";
        System.out.println(all_longest_common_subsequences(s1, s2));

        String s3 = "abaaa";
        String s4 = "baabaca";
        System.out.println(all_longest_common_subsequences(s3, s4));
    }
}
