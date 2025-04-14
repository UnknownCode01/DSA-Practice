import java.util.*;
class Solution{
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> hm = new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            hm.put(nums1[i][0],nums1[i][1]);
        }
        for(int i=0;i<nums2.length;i++){
            int temp = hm.getOrDefault(nums2[i][0],0);
            hm.put(nums2[i][0],nums2[i][1]+temp);
        }
        int n = hm.size();
        int[][] ans = new int[n][2];
        int k = 0;
        for(int i:hm.keySet()){
            ans[k][0] = i;
            ans[k++][1] = hm.get(i);
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] ans = mergeArrays(nums1, nums2);
        int n = ans.length;
        int m = ans[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}