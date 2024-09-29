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
    static class BinaryTree{
        static int idx=-1;
        public Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    public static int diameter(Node node){
        if(node==null){
            return 0;
        }
        int lD=diameter(node.left);
        int lH=height(node.left);
        int rD=diameter(node.right);
        int rH=height(node.right);
        int sD=lH+rH+1;
        return Math.max(sD,Math.max(lD,rD));
    }
    public static int height(Node node){
        if(node==null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int h = Math.max(lh,rh)+1;
        return h;
    }
    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.println(diameter(root));
        
    }
}