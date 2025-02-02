import java.util.*;
class Solution{
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i<t.length();i++){
            char c = t.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        // Set<Character> set = hm.keySet();
        // for(char c: set){
        //     System.out.println(c+"->"+hm.get(c));
        // }
        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int index = -1;
        while(r<s.length()){
            if(hm.getOrDefault(s.charAt(r),0)>0){
                count++;
            }
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)-1);
            while(count==t.length()){
                if(r-l+1<=minLength){
                    minLength = Math.min(minLength,r-l+1);
                    index = l;
                }
                hm.put(s.charAt(l),hm.getOrDefault(s.charAt(l),0)+1);
                if(hm.get(s.charAt(l))>0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return index==-1?"":s.substring(index, index+minLength);
    }
    public static void main(String[] args){
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s,t));
    }
}