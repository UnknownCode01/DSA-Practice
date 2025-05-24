import java.util.*;

class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        ans.add(new ArrayList<>(temp1));
        for(int i=2;i<=numRows;i++){
            List<Integer> temp2 = new ArrayList<>(temp1);
            temp2.add(0,0);
            temp2.add(0);
            temp1.clear();
            for(int j=0;j<temp2.size()-1;j++){
                temp1.add(temp2.get(j)+temp2.get(j+1));
            }
            ans.add(new ArrayList<>(temp1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));
    }
}