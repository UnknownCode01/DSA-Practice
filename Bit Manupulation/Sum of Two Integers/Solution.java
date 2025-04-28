class Solution {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b; // sum without carry
            int carry = (a & b) << 1; // carry shifted left
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println(getSum(a, b));
    }
}