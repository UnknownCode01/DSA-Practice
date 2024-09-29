import java.util.*;
class Solution{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static void getInorder(Node node,ArrayList<Integer> ar){
        if(node==null){
            return;
        }
        getInorder(node.left,ar);
        ar.add(node.data);
        getInorder(node.right,ar);
    }
    public static Node createBalancedBST(ArrayList<Integer> ar, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = new Node(ar.get(mid));
        node.left = createBalancedBST(ar,start,mid-1);
        node.right = createBalancedBST(ar,mid+1,end);
        return node;
    }
    public static Node balanceBST(Node root){
        ArrayList<Integer> ar = new ArrayList<>();
        getInorder(root,ar);
        root = createBalancedBST(ar,0,ar.size()-1);
        return root;
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
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root = balanceBST(root);
        preorder(root);
    }
}