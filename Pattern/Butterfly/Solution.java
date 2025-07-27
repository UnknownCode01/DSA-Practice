class Solution {
    public static void f(int n) {
        // Upper
        int spaces = 2 * (n - 1);
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            spaces -= 2;
        }
        // Lower
        spaces = 2;
        int m = n - 1;
        for (int i = 0; i < m; i++) {
            // stars
            for (int j = 0; j < m - i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < m - i; j++) {
                System.out.print("*");
            }
            System.out.println();
            spaces += 2;
        }

    }

    public static void main(String[] args) {
        int n = 5;
        f(n);
    }
}