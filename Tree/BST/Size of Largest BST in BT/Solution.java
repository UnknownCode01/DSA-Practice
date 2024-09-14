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
    public static void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }

    }
    static int sizeBST = 0;
    public static Info isValid(Node node){
        if(node==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = isValid(node.left);
        Info rightInfo = isValid(node.right);
        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(node.data,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(node.data,Math.max(leftInfo.max,rightInfo.max));
        if(node.data<=leftInfo.max || node.data>=rightInfo.min){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            sizeBST = Math.max(sizeBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }

    public static void main(String[] args){

        Node root=new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        
        System.out.println("Inorder Traversal");
        inorder(root);
        System.out.println();
        isValid(root);
        System.out.println(sizeBST);
    }
}