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
    public static void isValid( ArrayList<Integer> ar){
        for(int i=1;i<ar.size();i++){
            if(ar.get(i)<=ar.get(i-1)){
                System.out.println("InValid for index "+(i-1)+" and "+i);
                return;
            }
        }
        System.out.println("Valid");
    }
    public static void setInorder(Node node, ArrayList<Integer> ar){
        if(node==null){
            return;
        }
        setInorder(node.left,ar);
        ar.add(node.data);
        setInorder(node.right,ar);

    }
    public static void arrTraverse(ArrayList<Integer> ar){
        for(int i=0;i<ar.size();i++){
            System.out.print(ar.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        // int[] arr = {5,1,3,4,2,7};
        // Node root=null;
        // for(int i=0;i<arr.length;i++){
        //     root=insert(root,arr[i]);
        // }
        Node root=new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.right = new Node(4);
        ArrayList<Integer> ar = new ArrayList<>();
        setInorder(root, ar);
        System.out.println("Inorder Traversal");
        inorder(root);
        System.out.println();
        System.out.println("ArrayList Traversal");
        arrTraverse(ar);
        isValid(ar);
    }
}