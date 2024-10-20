import java.util.*;
class Solution{
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow = true;
    }
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt((temp.length()-1));
            }
        }
    }
    public static void main(String[] args){
        String[] arr = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
}