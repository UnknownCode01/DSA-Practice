// Time Limit Exceeded
class Solution {
    static boolean f(int index, int n, int count, String s) {
        if (count < 0) {
            return false;
        }
        if (index == n) {
            return count == 0;
        }
        if (s.charAt(index) == '(') {
            return f(index + 1, n, count + 1, s);
        }
        if (s.charAt(index) == ')') {
            return f(index + 1, n, count - 1, s);
        }
        return f(index + 1, n, count + 1, s) || f(index + 1, n, count, s) || f(index + 1, n, count - 1, s);
    }

    public static boolean checkValidString(String s) {
        int n = s.length();
        return f(0, n, 0, s);
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(checkValidString(s));
    }
}