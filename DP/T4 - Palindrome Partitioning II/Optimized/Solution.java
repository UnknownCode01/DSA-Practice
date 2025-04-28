class Solution {
    static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int solve(String str, int i, int j, Integer[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (isPalindrome(str, i, j)) {
            dp[i][j] = 0;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {

            /*
             * An Optimization: We will make the partition only if the string till the
             * partition
             * (till Kth position) is a valid palindrome. Because the question states that
             * all
             * partition must be a valid palindrome. If we dont check this, we will have to
             * perform recursion on the left subproblem too (solve(str, i, k)) and we will
             * waste
             * a lot of time on subproblems that is not required. Without this the code will
             * give
             * correct answer but TLE on big test cases.
             */
            if (isPalindrome(str, i, k)) {
                int partitions = 1 + solve(str, k + 1, j, dp);
                min = Math.min(min, partitions);
            }
        }

        dp[i][j] = min;
        return dp[i][j];
    }

    public static int minCut(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return solve(s, 0, s.length() - 1, dp);
    }

    public static void main(String[] args) {
        String s = "nitik";
        System.out.println(minCut(s));
    }
}