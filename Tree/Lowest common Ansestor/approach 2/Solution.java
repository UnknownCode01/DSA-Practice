import java.util.*;

class Solution{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node lca(Node root, int x, int y){
        if(root==null){
            return null;
        }
        if(root.data==x || root.data==y){
            return root;
        }
        Node leftLca = lca(root.left,x,y);
        Node rightLca = lca(root.right,x,y);
        if(rightLca==null){
            return leftLca;
        }
        if(leftLca==null){
            return rightLca;
        }
        return root;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x = 4;
        int y = 7;
        System.out.println(lca(root,x,y).data);
    }
}