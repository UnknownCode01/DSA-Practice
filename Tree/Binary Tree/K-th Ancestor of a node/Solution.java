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
    static int kAncestor(Node node, int x, int k){
        if(node==null){
            return -1;
        }
        if(node.data==x){
            return 0;
        }
        int left = kAncestor(node.left, x, k);
        int right = kAncestor(node.right, x, k);
        if(left==-1 && right==-1){
            return -1;
        }
        int max = Math.max(left,right);
        if(max+1==k){
            System.out.println(node.data);
        }
        return max+1;
    }
     public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int find = 7;
        int k = 2;
        kAncestor(root, find, k);
    }
}