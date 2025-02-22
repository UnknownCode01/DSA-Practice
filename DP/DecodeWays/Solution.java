public class Solution {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one way to decode
        dp[1] = 1; // Single digit (non-zero) has one way to decode
        
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twos = Integer.parseInt(s.substring(i - 2, i));
            
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twos >= 10 && twos <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        String input = "1121";
        System.out.println(numDecodings(input)); // Output: 3
    }
}
