import java.util.*;

class Solution {
    public static int beautySum(String s) {
        int count = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            hm.clear();
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                int maxi = Collections.max(hm.values());
                int mini = Collections.min(hm.values());
                int b = maxi-mini;
                if(b>0){
                    count+=b;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        String s ="aabcbaa";
        System.out.println(beautySum(s));
    }
}

