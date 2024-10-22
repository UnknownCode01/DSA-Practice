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
    public static void main(String[] args){
        String[] arr = {"the","a","there","thee","their","any"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("th"));
    }
}