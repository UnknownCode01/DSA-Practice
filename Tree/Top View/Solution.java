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
    static class info{
        Node node;
        int hd;
        info(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min=0, max=0;
        q.add(new info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            info temp = q.remove();
            if(temp==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(temp.hd)){
                map.put(temp.hd,temp.node);
            }
            if(temp.node.Left!=null){
                q.add(new info(temp.node.Left,temp.hd-1));
                min = Math.min(min,temp.hd-1);
            }
            if(temp.node.Right!=null){
                q.add(new info(temp.node.Right,temp.hd+1));
                max = Math.max(max,temp.hd+1);
            }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }


    }
    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        topView(root);
        // LevelOrder_Tracersal(root);
        // System.out.println(root.data);
    }
}