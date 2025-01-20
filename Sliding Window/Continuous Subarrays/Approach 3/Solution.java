import java.util.*;
class Solution {
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int j = 0;
        long cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            System.out.println("->"+(i-j+1)+" "+getCount(nums[i], map));
            while ((i - j + 1) > getCount(nums[i], map)) {
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }
            System.out.print("[ ");
            for(int x=j;x<=i;x++){
                System.out.print(nums[x]+" ");
            }
            System.out.println("]");
            cnt += (i - j + 1);
        }

        return cnt;
    }

    private static int getCount(int num, Map<Integer, Integer> map) {
        return map.getOrDefault(num, 0) + map.getOrDefault(num - 1, 0) +
            map.getOrDefault(num + 1, 0) + map.getOrDefault(num - 2, 0) +
            map.getOrDefault(num + 2, 0);
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(continuousSubarrays(nums));
    }
}
