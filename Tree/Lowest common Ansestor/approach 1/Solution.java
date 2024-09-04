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
    public static boolean getPath(Node node, int no, ArrayList<Node> path){
        if(node==null){
            return false;
        }
        path.add(node);
        if(node.data==no){
            return true;
        }
        boolean foundLeft = getPath(node.left, no, path);
        boolean foundRight = getPath(node.right, no, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int x, int y){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root,x,path1);
        getPath(root,y,path2);
        Node ans = new Node(-1);
        for(int i=0;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)==path2.get(i)){
                ans = path1.get(i);
            }else{
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x = 5;
        int y = 6;
        System.out.println(lca(root,x,y).data);
    }
}