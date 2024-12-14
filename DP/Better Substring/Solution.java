import java.util.*;

public class Solution {

    public static String betterString(String str1, String str2) {
        // Calculate the number of distinct subsequences for both strings
        int subsequences1 = countDistinctSubsequences(str1);
        int subsequences2 = countDistinctSubsequences(str2);
        System.out.println("ans: "+subsequences1+" "+subsequences2);
        // Return the string with the greater number of distinct subsequences
        if (subsequences1 >= subsequences2) {
            return str1;
        } else {
            return str2;
        }
    }

    private static int countDistinctSubsequences(String s) {
        int n = s.length();
        // dp[i] will store the number of distinct subsequences of the substring s[0...i-1]
        int[] dp = new int[n + 1];
        dp[0] = 1; // The empty subsequence

        // HashMap to store the last index of each character
        Map<Character, Integer> lastSeen = new HashMap<>();
        System.out.println("dp for "+s);
        for (int i = 1; i <= n; i++) {
            // Every subsequence from the previous index can be extended by s[i-1]
            dp[i] = 2 * dp[i - 1];

            // If this character has been seen before, subtract the subsequences
            // that have been double-counted due to the repeated character
            char ch = s.charAt(i - 1);
            if (lastSeen.containsKey(ch)) {
                dp[i] -= dp[lastSeen.get(ch) - 1];
            }

            // Update the last seen index of the current character
            lastSeen.put(ch, i);
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        // Example 1
        String str1 = "ljmolmti";
        String str2 = "sqapzwbb";
        System.out.println(betterString(str1, str2)); 

        // Example 2
        str1 = "aaa";
        str2 = "baa";
        System.out.println(betterString(str1, str2)); 
    }
}
