import java.util.*;
class Solution {
    public static void f(int[] candidates, int n, int target, int index,  int sum, List<List<Integer>> list, List<Integer> temp){      
        if(sum==target){
            list.add(new ArrayList<>(temp));
            return;
        }       
        for(int i=index;i<n;i++){
            if(i> index && candidates[i]==candidates[i-1])  continue;
            if(sum+candidates[i]>target)    break;
            temp.add(candidates[i]);
            f(candidates, n, target, i+1, sum+candidates[i], list, temp);
            temp.remove(temp.size()-1);
        }    
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        int index = 0;
        int sum = 0;
        f(candidates, n, target, index, sum, list, temp);
        return list;
    }
    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(candidates); //1,1,2,5,6,7,10
        List<List<Integer>> list = combinationSum2(candidates, target);
        System.out.println(list);
    }
}