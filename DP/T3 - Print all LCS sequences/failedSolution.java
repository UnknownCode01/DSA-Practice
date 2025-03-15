import java.util.*;//Time limit exceeded

class failedSolution {
    public static void findAllLCS(String text1, String text2, int[][] dp, int i, int j, StringBuilder temp,
            Set<String> result) {
        if (i == 0 || j == 0) {
            result.add(temp.reverse().toString()); // Reverse as we built it backwards
            temp.reverse(); // Revert the change to backtrack properly
            return;
        }

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            temp.append(text1.charAt(i - 1));
            findAllLCS(text1, text2, dp, i - 1, j - 1, temp, result);
            temp.deleteCharAt(temp.length() - 1); // Backtrack
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                findAllLCS(text1, text2, dp, i - 1, j, temp, result);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                findAllLCS(text1, text2, dp, i, j - 1, temp, result);
            }
        }
    }

    public static List<String> longestCommonSubsequence(String text1, String text2, List<String> ls) {
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

        Set<String> result = new TreeSet<>(); // TreeSet maintains lexicographical order
        findAllLCS(text1, text2, dp, n, m, new StringBuilder(), result);

        return new ArrayList<>(result);
    }

    static List<String> all_longest_common_subsequences(String s, String t) {
        List<String> ls = new LinkedList<>();
        return longestCommonSubsequence(s, t, ls);
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