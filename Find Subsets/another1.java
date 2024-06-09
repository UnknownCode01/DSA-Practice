import java.util.*;
class another1{
     public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int i){
        if(i==nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        backtrack(list, tempList.add(nums[i])?tempList:tempList, nums, i+1);
        tempList.remove(tempList.size()-1);
        backtrack(list, tempList, nums, i+1);
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }
}
