class Solution {
    // static boolean f(int index, int n, int count, String s) {
    // if (count < 0) {
    // return false;
    // }
    // if (index == n) {
    // return count == 0;
    // }
    // if (s.charAt(index) == '(') {
    // return f(index + 1, n, count + 1, s);
    // }
    // if (s.charAt(index) == ')') {
    // return f(index + 1, n, count - 1, s);
    // }
    // return f(index + 1, n, count + 1, s) || f(index + 1, n, count, s) || f(index
    // + 1, n, count - 1, s);
    // }

    public static boolean checkValidString(String s) {
        int n = s.length();
        int mini = 0;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                mini++;
                maxi++;
            } else if (s.charAt(i) == ')') {
                mini--;
                maxi--;
            } else {
                mini--;
                maxi++;
                
            }
            if (mini < 0) {
                mini = 0;
            }
            if (maxi < 0) {
                return false;
            }
        }
        return mini==0;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(checkValidString(s));
    }
}