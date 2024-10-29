import java.util.*;
class Solution{
    static long substrCount (String S, int K) {
        //now we computed for atmost k -> meaning if k =2 , then (1,2)
        //so we do atmost k - atmost k-1 -> (1,2) - (1) -> gives us 2 which is required
        return kDistinctSubstrings(S,K) - kDistinctSubstrings(S,K-1);
    }
    
    //this fuction computes the atmost k distinct characters in give string with its substrings
    static long kDistinctSubstrings(String s,int k){
        int i=0,j=0;//these will be pointers for our window
        
        int distinct = 0;
        long ans = 0;
        
        //we also need to hashmap for checking the characters distinct or not
        int[] map = new int[26];//for 26 alphabets
        while(j<s.length()){
            map[s.charAt(j)-'a']++;//first you put the character in the map or 'a' ->97
            
            //check if it was its first occurence
            if(map[s.charAt(j)-'a'] == 1){
                distinct++;
            }
            
            //decrease the window based on if distinct exceeds the k, for reducing we go with from left side index which is i
            while(distinct > k){
                map[s.charAt(i)-'a']--;
                if(map[s.charAt(i)-'a'] == 0) distinct--;
                i++;
            }
            
            ans += (j-i+1);
            j++;
        }
        
        return ans;
        
    }
    public static void main(String[] args){
        String S = "aabaac";
        System.out.println(substrCount(S,2));
    }
}