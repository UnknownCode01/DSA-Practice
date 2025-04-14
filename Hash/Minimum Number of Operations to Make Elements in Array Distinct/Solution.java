import java.util.*;

class Solution {
    public static int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int operations = 0;
        while (true) {
            Set<Integer> set = new HashSet<>(list);
            if (set.size() == list.size()) {
                break;
            }
            int removeCount = Math.min(3, list.size());
            for (int i = 0; i < removeCount; i++) {
                list.remove(0);
            }
            operations++;
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 4, 4 };
        System.out.println(minimumOperations(nums));
    }
}