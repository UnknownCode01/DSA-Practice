import java.util.*;
class Solution{
    public static int ls(String s, int k){
        int count = 0;
        int l = 0;
        int r= 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(r<s.length()){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0)+1);
            if(hm.size()>k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l))==0){
                    hm.remove(s.charAt(l));
                }
                l++;
            }
            if(hm.size()<=k){
                count = Math.max(count,(r-l+1));
            }
            r++;
        }
        return count;
    }
    
    public static void main(String[] args){
        String s = "aaabbccd";
        System.out.println(ls(s,2));
    }
}