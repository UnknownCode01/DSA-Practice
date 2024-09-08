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
    static class Info{
        int diam;
        int ht;
        Info(int diam, int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter(Node node){
        if(node==null){
            return new Info(0,0);
        }
        Info lI = diameter(node.left);
        Info rI = diameter(node.right);
        int diam = Math.max(Math.max(lI.diam,rI.diam),lI.ht+rI.ht+1);
        int ht = Math.max(lI.ht,rI.ht)+1;
        return new Info(diam,ht);        
    }

    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.println(diameter(root).diam);
        
    }
}