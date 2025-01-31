//O(N)
import java.util.*;
class Solution{
    public static int characterReplacement(String s, int k) {
        int l=0,r=0;
        int n = s.length();
        int maxf = 0;
        int maxLength = 0;
        int[] hash = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxf = Math.max(maxf,hash[s.charAt(r)-'A']);
            int changes = r-l+1-maxf;
            if(r-l+1-maxf<=k){
                maxLength = Math.max(maxLength,r-l+1);
            }else{
                hash[s.charAt(l)-'A']--;
                maxf=0;
                for(int i=0;i<26;i++){
                    maxf = Math.max(maxf,hash[i]);
                }
                l++;
            }
            r++;
        }
        return maxLength;
    }
    public static void main(String[] args){
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s,k));
    }
}