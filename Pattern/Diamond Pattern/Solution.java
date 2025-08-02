class Solution {
    public static void f(int n) {
        // Upper Half
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Lower Half
        int m = n - 1;
        for (int i = 0; i < m; i++) {
            // Spaces
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 0; j < m - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        f(n);
    }
}