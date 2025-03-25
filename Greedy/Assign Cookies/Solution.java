import java.util.*;
class Solution{
    public static int findContentChildren(int[] g, int[] s) {
        int ans= 0;
        int l = 0;
        int r = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<s.length && r<g.length){
            if(s[l]>=g[r]){
                ans++;
                r++;
            }
            l++;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g,s));
    }
}