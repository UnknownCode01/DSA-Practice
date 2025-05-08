import java.util.*;

class Solution {
    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            String key = a + "," + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int val : map.values()) {
            count += val * (val - 1) / 2; // nC2
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] dominoes = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
        System.out.println(numEquivDominoPairs(dominoes));
    }
}