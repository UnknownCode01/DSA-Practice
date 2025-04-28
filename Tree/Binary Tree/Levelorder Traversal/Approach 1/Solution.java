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
    public static void LevelOrder_Tracersal(Node node){
        if(node==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.Left!=null){
                    q.add(temp.Left);
                }
                if(temp.Right!=null){
                    q.add(temp.Right);
                }
            }
        }

    }
    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        LevelOrder_Tracersal(root);
        // System.out.println(root.data);
    }
}