import java.util.*;
class Solution{
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && st.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        String s = "apple";
        List<String> wordDict = Arrays.asList("a","app","le");
        System.out.println(wordBreak(s,wordDict));
    }
}