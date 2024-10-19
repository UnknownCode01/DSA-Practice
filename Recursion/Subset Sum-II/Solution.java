import java.util.*;
class Solution{
    public static void f(int[] nums,int n, int index,List<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<n;i++){
            if(i!=index && nums[i]==nums[i-1])  continue;
            temp.add(nums[i]);
            f(nums, n, i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index=0;
        Arrays.sort(nums);
        f(nums, nums.length, index, temp, ans);
        return ans;
    }
    public static void main(String[] args){
        int[] nums ={1,2,2};
        List<List<Integer>> arr = subsetsWithDup(nums);
        System.out.println(arr);
    }
}