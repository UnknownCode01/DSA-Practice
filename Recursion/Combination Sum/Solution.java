import java.util.*;
class Solution {
    public static void f(int[] candidates, int n, int target, int index,  int sum, List<List<Integer>> list, List<Integer> temp){
        if(sum>target){
            return;
        }
        if(index==n){
            if(sum==target){
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(candidates[index]);
        f(candidates, n, target, index, sum+candidates[index], list, temp);
        temp.remove(temp.size()-1);
        f(candidates, n, target, index+1, sum, list, temp);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        int index = 0;
        int sum = 0;
        f(candidates, n, target, index, sum, list, temp);
        return list;
    }
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> list = combinationSum(candidates, target);
        System.out.println(list);
    }
}