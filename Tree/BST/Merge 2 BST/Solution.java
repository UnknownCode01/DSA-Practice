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
    public static Node balanceBST(Node root1, Node root2){
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        getInorder(root1,ar1);
        getInorder(root2,ar2);
        int n2 = ar2.size();
        for(int i=0;i<n2;i++){
            ar1.add(ar2.get(i));
        }
        int n1 = ar1.size();
        Collections.sort(ar1);
        root1 = createBalancedBST(ar1,0,n1-1);
        return root1;
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        
        Node root = balanceBST(root1,root2);
        preorder(root);
    }
}