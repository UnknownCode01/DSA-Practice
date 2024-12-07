import java.util.*;
class Solution {
    public static void func(int index, String s, List<String> temp, List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                func(i+1,s,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        func(0,s,temp,ans);
        return ans;
    }
    public static void main(String[] args){
        String s = "aabb";
        List<List<String>> li= partition(s);
        System.out.println(li);
    }
}