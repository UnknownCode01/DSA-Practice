import java.util.*;

class Solution {
    public static String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            int half = freq[i] / 2;
            while (half-- > 0) {
                left.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1 && middle.isEmpty()) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();
        return left.toString() + middle + right.toString();
    }

    public static void main(String[] args) {
        String s = "daccad";
        System.out.println(smallestPalindrome(s));
    }
}