import java.util.*;

class Solution {
    public static boolean isHappy(int n) {
        if (n == 1)
            return true;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(n, 1);
        while (true) {
            count = 0;
            while (n > 0) {
                int d = (n % 10);
                count += d * d;
                n /= 10;
            }
            if (count == 1) {
                return true;
            }
            if (hm.containsKey(count)) {
                return false;
            }
            hm.put(count, 1);
            n = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
}