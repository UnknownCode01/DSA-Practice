import java.util.*;
class Solution{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node node, int value){
        if(node==null){
            node = new Node(value);
            return node;
        }
        if(node.data>value){
            node.left=insert(node.left,value);
        }
        else{
            node.right=insert(node.right,value);
        }
        return node;
    }
    public static void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public static void main(String[] args){
        int[] arr = {5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root,arr[i]);
        }
        inorder(root);
        System.out.println();
    }
}