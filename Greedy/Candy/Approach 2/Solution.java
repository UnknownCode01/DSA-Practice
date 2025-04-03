import java.util.*;

class Solution {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }
        int sum = 1;
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }
            if (down > peak) {
                sum += down - peak;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy(ratings));
    }
}