import java.util.*;
class Solution{
    static long substrCount (String S, int K) {
        long ans =0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<=S.length()-K;i++){
            int j=i+K-1;
            if(i==j){
                hm.put(S.charAt(i),hm.getOrDefault(j,0)+1);
            }
            else{
                for(int k=i;k<=j;k++){
                    char x = S.charAt(k);
                    hm.put(x,hm.getOrDefault(x,0)+1);
                }
            }
            for(;j<S.length();){
                // System.out.println(i+" "+j);
                int k=hm.keySet().size();
                // System.out.println("k="+k);
                if(k>K){
                    hm.clear();
                    break;
                }else{
                    if(k==K){
                        ans++;
                    }
                    // System.out.println("ans="+ans);
                    j++;
                    if(j<S.length()){
                        hm.put(S.charAt(j),hm.getOrDefault(j,0)+1);    
                    }
                }
            }
            hm.clear();
        }
        return ans;
    }
    public static void main(String[] args){
        String S = "abaaca";
        System.out.println(substrCount(S,1));
    }
}