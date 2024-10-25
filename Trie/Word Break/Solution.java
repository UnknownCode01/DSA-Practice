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
    public static boolean search(String key){
        Node curr = root;
        for(int i=0;i<key.length();i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow == true;
    }
    public static boolean wordbreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=0;i<key.length();i++){
            if(search(key.substring(0,i+1)) &&
            wordbreak(key.substring(i+1))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String[] arr = {"i","like","sam","samsung","mobile","ice"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        System.out.println(wordbreak("ilikesamsung"));
        System.out.println(wordbreak("ilikesam"));
        System.out.println(wordbreak("ilikesung"));
    }
}