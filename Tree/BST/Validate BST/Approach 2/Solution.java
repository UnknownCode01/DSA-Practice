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

    public static boolean isValid(Node node, Node min, Node max){
        if(node==null){
            return true;
        }
        if(min!=null && node.data<=min.data){
            return false;
        }
        if(max!=null && node.data>=max.data){
            return false;
        }
        return isValid(node.left,min,node) && isValid(node.right,node,max);
    }

    public static void main(String[] args){
        // int[] arr = {5,1,3,4,2,7};
        // Node root=null;
        // for(int i=0;i<arr.length;i++){
        //     root=insert(root,arr[i]);
        // }
        Node root=new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.right = new Node(7);

        System.out.println("Inorder Traversal");
        inorder(root);
        System.out.println();
        System.out.println(isValid(root,null,null));
    }
}