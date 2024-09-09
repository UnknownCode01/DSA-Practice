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
    public static boolean search(Node node, int key){
        if(node==null){
            return false;
        }
        if(node.data==key){
            return true;
        }
        if(node.data>key){
            return search(node.left, key);
        }
        else{
            return search(node.right,key);
        }
    }
    public static Node delete(Node node, int value){
        if(node.data>value){
            node.left=delete(node.left, value);
        }else if(node.data<value){
            node.right=delete(node.right, value);
        }else{
            if(node.left==null && node.right==null){
                return null;
            }
            else if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else{
                Node IS = findIS(node.right);
                node.data = IS.data;
                node.right = delete(node.right,node.data);
            }
        }
        return node;
    }
    public static Node findIS(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    public static void main(String[] args){
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root,arr[i]);
        }
        inorder(root);
        delete(root, 5);
        System.out.println();
        inorder(root);
    }
}