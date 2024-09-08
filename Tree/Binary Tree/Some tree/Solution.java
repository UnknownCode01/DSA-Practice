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
    public static int someTree(Node node){
        if(node==null){
            return 0;
        }
        int left = someTree(node.left);
        int right = someTree(node.right);
        int p = node.data;
        int newLeft = node.left==null?0:node.left.data;
        int newRight = node.right==null?0:node.right.data;
        node.data = left+newLeft+right+newRight;
        return p;
    }
    public static void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
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
        someTree(root);
        preorder(root);
    }
}