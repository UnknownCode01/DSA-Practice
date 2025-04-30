import java.util.*;

class Solution {
    static int evenlyDivides(int n) {
        int ans = 0;
        int temp = n;
        ArrayList<Integer> arr = new ArrayList<>();
        while (n > 0) {
            int rem = n % 10;
            arr.add(rem);
            n /= 10;
        }
        for (int i : arr) {
            if (i!=0 && temp % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2446;
        System.out.println(evenlyDivides(n));
    }
}