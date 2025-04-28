import java.util.*;

class Solution {
    public static int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> st = new HashSet<>();
        for (int i : nums) {
            st.add(i);
        }
        for (int i : st) {
            if (st.contains(i - 1)) {
                continue;
            }
            int c = 1;
            while (st.contains(i + 1)) {
                c++;
                i++;
            }
            longest = Math.max(c, longest);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }
}