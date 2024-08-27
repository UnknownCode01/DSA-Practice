import java.util.*;
class Solution{
    static class Node{
        int data;
        Node Left;
        Node Right;
        Node(int data){
            this.data = data;
            this.Left = null;
            this.Right = null;
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
            newNode.Left=buildTree(nodes);
            newNode.Right=buildTree(nodes);
            return newNode;
        }
    }
    public static void Postorder_Traversal(Node node){
        if(node==null){
            return;
        }
        Postorder_Traversal(node.Left);
        Postorder_Traversal(node.Right);
        System.out.print(node.data+" ");

    }
    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        Postorder_Traversal(root);
        // System.out.println(root.data);
    }
}