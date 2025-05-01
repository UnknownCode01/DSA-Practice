class Solution {
    public static int count(String s, int l, int r) {
        int ans = 0;
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            ans++;
            l--;
            r++;
        }
        return ans;
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int even = count(s, i, i + 1);
            int odd = count(s, i - 1, i + 1);
            ans += 1 + even + odd;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "nitin";
        System.out.println(countSubstrings(s));
    }
}