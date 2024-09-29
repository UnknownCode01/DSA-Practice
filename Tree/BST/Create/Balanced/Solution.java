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
    public static Node balancedBST(int[] arr, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        node.left = balancedBST(arr,start,mid-1);
        node.right = balancedBST(arr,mid+1,end);
        return node;
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
        int[] arr = {3,5,6,8,10,11,12};
        Node root = balancedBST(arr,0,arr.length-1);
        preorder(root);
    }
}