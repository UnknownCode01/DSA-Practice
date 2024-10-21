import java.util.*;
class Solution{
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=0;
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
                curr.freq++;
            }else{
                curr.freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static String freqMatch(String word){
        Node curr=root;
        String str = "";
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.freq!=1){
                str=str+word.charAt(i);  
            }
            else{
                return str;
            }
            curr=curr.children[idx]; 
        }
        return str;
    }
    public static void main(String[] args){
        String[] arr = {"zebra","dog","duck","dove"};
        ArrayList<String> al = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            al.add(freqMatch(arr[i]));
        }
        System.out.println(al);
    }
}