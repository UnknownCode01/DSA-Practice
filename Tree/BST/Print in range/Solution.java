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
    public static void printInRange(Node node, int k1, int k2){
        if(node==null){
            return;
        }
        if(node.data>=k1 && node.data<=k2){
            printInRange(node.left, k1, k2);
            System.out.print(node.data+" ");
            printInRange(node.right, k1, k2);
        }
        else if(node.data<k1){
            printInRange(node.right, k1, k2);
        }
        else{
            printInRange(node.left, k1, k2);
        }
    }
    public static void main(String[] args){
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root,arr[i]);
        }
        printInRange(root, 10, 12);

    }
}