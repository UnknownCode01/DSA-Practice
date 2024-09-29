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
    public static void paths(Node node, ArrayList<Integer> ar){
        if(node==null){
            return;
        }
        ar.add(node.data);
        if(node.left==null && node.right==null){
            for(int i=0;i<ar.size();i++){
                System.out.print(ar.get(i)+"->");
            }
            System.out.println("null");
        }
        paths(node.left, ar);
        paths(node.right, ar);
        ar.remove(ar.size()-1);        
    }
    public static void main(String[] args){
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root,arr[i]);
        }
        ArrayList<Integer> ar = new ArrayList<>();
        paths(root, ar);

    }
}